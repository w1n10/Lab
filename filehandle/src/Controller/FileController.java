
package Controller;

import Addition.Validation;
import Model.Person;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileController {
    Validation vl = new Validation();
    Scanner sc = new Scanner(System.in);
    private List<Person> pL = new ArrayList<>();
    
    public void getFilePathInput() {
        String filepathsource = vl.getNonEmptyString("Enter file path source:");
        String filepathdestination = vl.getNonEmptyString("Enter file path destination:");
        try {
            FileReader fileReader = new FileReader(filepathsource);
        }catch (IOException e) {
            System.out.println("File path doesn't exist: " + e.getMessage());
        }
        Copyfiletofile(filepathsource,filepathdestination);
    }
    
    public void Copyfiletofile(String sourceFilePath, String destinationFilePath){
        try {
            FileReader fileReader = new FileReader(sourceFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(destinationFilePath);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); 

                for (String word : words) {
                    fileWriter.write(word + " ");
                }
            }

            bufferedReader.close();
            fileWriter.close();

            System.out.println("Successfully copied the text to the new file.");
        } catch (IOException e) {
            System.out.println("An error occurred while copying the text file: " + e.getMessage());
        }
    }
    
    private void filterAndDisplayPersons(List<Person> persons, double minSalary) {
        System.out.println("Persons with salary greater than " + minSalary + ":");
        System.out.println("Name\t\tAddress\t\tMoney");
        for (Person person : persons) {
            if (person.getSalary() > minSalary) {
                System.out.println(person.toString());
            }
        }
    }
    public void Function1(){
        String filepathsource = vl.getNonEmptyString("Enter file path source:");
        try {
            FileReader fileReader = new FileReader(filepathsource);
            try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(";"); 
                if (info.length == 3) {
                String name = info[0];
                String address = info[1];
                double salary = 0;
                try{
                salary = Double.parseDouble(info[2]);}
                catch (Exception e){salary = 0;}
                if (name==null) name ="0";
                if (address==null) address ="0";
                Person student = new Person(name, address, salary);
                pL.add(student);
            } 
            }
            bufferedReader.close();
            System.out.println("Successfully readfile.");
        } catch (IOException e) {
            System.out.println("An error occurred while read the text file: " + e.getMessage());
        }
            System.out.println("Enter Salary: ");
            double minSalary = sc.nextDouble();
            filterAndDisplayPersons(pL,minSalary);
            displayPersonsWithLeastAndMostMoney(pL);
        }catch (IOException e) {
            System.out.println("File path doesn't exist: " + e.getMessage());
        }
    }
    
     public void displayPersonsWithLeastAndMostMoney(List<Person> persons) {
        double minSalary = Double.MAX_VALUE;
        double maxSalary = Double.MIN_VALUE;
        String personWithLeastMoney = null;
        String personWithMostMoney = null;

        for (Person person : persons) {
            double salary = person.getSalary();
            if (salary < minSalary) {
                minSalary = salary;
                personWithLeastMoney = person.getName();
            }
            if (salary > maxSalary) {
                maxSalary = salary;
                personWithMostMoney = person.getName();
            }
        }

        System.out.println("Person with the least amount of money:");
        System.out.println(personWithLeastMoney);

        System.out.println("Person with the most amount of money:");
        System.out.println(personWithMostMoney);
    }
}
