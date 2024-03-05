package controller;

import model.Person;
import view.PersonView;
import java.util.ArrayList;

public class Personcontroller {

    int i = 0;

    public void addPerson(String name, String add, double salary, Person[] personList) {
        Person person = new Person(name, add, salary);
        personList[i] = person;
        i++;
    }

    public  Person[] sortBySalary(Person[] persons) {
        int n = persons.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (persons[i - 1].getSalary() > persons[i].getSalary()) {
                    
                    Person temp = persons[i - 1];
                    persons[i - 1] = persons[i];
                    persons[i] = temp;

                    swapped = true;
                }
            }

            n--;

        } while (swapped);

        return persons;
    }

    public void run(Person[] personList) {
        PersonView view = new PersonView();
        view.UIview(personList);
        sortBySalary(personList);
        view.displayPerson(personList);
    }
}
