package Homework08;

import fmi.informatics.extending.Person;

import java.util.ArrayList;

public class Personn{


    int names;
    private String fName = "Ivan";
    private String mName = "Dimitrov";
    private String lName = "Ivanov";

    public Personn(ArrayList<Person> peopleList) {

    }


    public void Person(String f, String m, String l) {
        this.fName = f;
        this.mName = m;
        this.lName = l;
    }

    public void Person(String firstName, int nameCounter) {
        this.fName = firstName;
        this.names = nameCounter;

    }

    public int getNameCounter() {
        return names;
    }

    public void setNameCounter(int nameCounter) {
        this.names = nameCounter;
    }

    public String getFirstName() {
        return fName;
    }

    public void setFirstName(String firstName) {
        this.fName = firstName;
    }

    public String getMiddleName() {
        return mName;
    }

    public void setMiddleName(String middleName) {
        this.mName = middleName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

}