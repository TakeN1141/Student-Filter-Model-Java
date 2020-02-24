package Homework08;

import fmi.informatics.extending.Person;

import javax.swing.table.AbstractTableModel;

    public class FilterModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        Person[] people;

        public FilterModel(Person[] people) {

        }

        // constructor
        public void FilterDataModel(Person[] people) {
            this.people = people;
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return people.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return people[rowIndex].getFirstName();
                case 1:
                    return people[rowIndex].getNameCounter();

            }
            return null;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "First name";
                case 1:
                    return "Name Count";
                default:
                    return super.getColumnName(column);
            }
        }
    }

