package view;

import common.Checkvalid;
import controller.Personcontroller;
import java.util.ArrayList;
import java.util.Scanner;
import model.Person;

public class PersonView {

    Checkvalid data = new Checkvalid();
    Personcontroller control = new Personcontroller();
    Scanner scanner = new Scanner(System.in);
    public void UIview(Person[] personList) {
        int i=0;
        System.out.println("=====Management Person programer=====");
        while (i<3) {
            System.out.println("Input Information of Person");
            String name = data.getString("Please input name:");
            String add = data.getString("Please input address:");
            double salary = data.getSalary("Please input salary:");
            control.addPerson(name, add, salary,personList);
            i++;
        }
    }

    public void displayPerson(Person[] List) {
        for (Person person : List) {
            System.out.println("Information of Person you have entered:") ;
            System.out.println("Name: "+ person.getName()) ;
            System.out.println("Address: "+ person.getAddress()) ;
            System.out.println("Salary: "+ person.getSalary()+ "\n") ;
       }
    }
}
