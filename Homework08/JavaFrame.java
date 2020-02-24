package Homework08;

import fmi.informatics.extending.Person;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;



public class JavaFrame extends JFrame{

    private static final long serialVersionUID = 1L;
    fmi.informatics.util.FileReader read = new fmi.informatics.util.FileReader();
    Person[] people = read.readPeople();
    ArrayList<Person> peopleList = new ArrayList<Person>();
    public <PersonModel> JavaFrame() {
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));

        for (Person person : people) {
            peopleList.add(person);
        }

        JPanel buttonPanel = new JPanel();
        JPanel tablePanel = new JPanel();

        JButton sortLastASCButton = new JButton("Sort Last Name (ASC)");
        JButton sortLastDSCButton = new JButton("Sort Last Name (DSC)");
        JButton sortFirstASCButton = new JButton("Sort First Name (ASC)");
        JButton sortFirstDSCButton = new JButton("Sort First Name (DSC)");
        JButton searchFamilyButton = new JButton("Search Family Name");
        JButton firstNameCountButton = new JButton("Filter First Name");

        Personn personModel = new Personn(peopleList);

        JTable table = new JTable((TableModel) personModel);
        JScrollPane scroller = new JScrollPane(table);
        this.add(tablePanel);
        this.add(buttonPanel);

        buttonPanel.setLayout(new GridLayout(3,1));
        buttonPanel.add(sortLastASCButton);
        buttonPanel.add(sortLastDSCButton);
        buttonPanel.add(sortFirstASCButton);
        buttonPanel.add(sortFirstDSCButton);
        buttonPanel.add(searchFamilyButton);
        buttonPanel.add(firstNameCountButton);

        scroller.setPreferredSize(new Dimension(550,200));
        tablePanel.add(scroller);

        firstNameCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person[] people = new Person[1];
                people[0] = new Person() {
                    @Override
                    public void study() {

                    }

                    @Override
                    public void think() {

                    }

                    @Override
                    public void act() {

                    }

                    @Override
                    public void getUpEarly(Calendar hour) {

                    }

                    @Override
                    public void run(int minutes) {

                    }

                    @Override
                    protected String getTypicalDrink() {
                        return null;
                    }

                    @Override
                    public Object getFirstName() {
                        return null;
                    }

                    @Override
                    public Object getNameCounter() {
                        return null;
                    }

                    @Override
                    public <T> Comparable getLastName() {
                        return null;
                    }

                    @Override
                    public void setFirstName(String input) {

                    }

                    @Override
                    public void setNameCounter(int counter) {

                    }
                };
                String input = JOptionPane.showInputDialog("Enter name you wish to count:");
                int counter = 0;
                for(int i = 0;i<peopleList.size();i++) {
                    if(peopleList.get(i).getFirstName().toString().equals(input)) {
                        counter++;
                    }
                }
                FilterModel filterDataModel = new FilterModel(people);

                people[0].setFirstName(input);
                people[0].setNameCounter(counter);

                table.setModel(filterDataModel);
                table.repaint();
            }
        });

        searchFamilyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter last name you are looking for:");
                for(int i = 0;i<peopleList.size();i++) {
                    if(!(peopleList.get(i).getLastName().toString().equals(input))) {
                        peopleList.remove(i);
                    }
                }
                table.repaint();
            }
        });

        sortLastASCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Collections.sort(peopleList, new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p1.getLastName().compareTo(p2.getLastName());
                    }
                });
                table.repaint();
            }
        });

        sortLastDSCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Collections.sort(peopleList, new Comparator<Person>() {
                    @Override
                    public int compare(Person p1, Person p2) {
                        return p2.getLastName().compareTo(p1.getLastName());
                    }
                });
                table.repaint();
            }
        });



        this.setVisible(true);
    }
}