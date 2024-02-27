package Controller;

import Model.Fruit;
import Model.Order;
import Model.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitManage {

    private List<Fruit> fruits = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Validation validation = new Validation();
    private Order order;

public void createFruit() {
    System.out.println("Create Fruit");
    System.out.print("Enter Fruit Id: ");
    String fruitId = validation.getNonEmptyString("Enter fruit ID: ");


    Fruit existingFruit = null;
    for (Fruit fruit : fruits) {
        if (fruit.getFid().equals(fruitId)) {
            existingFruit = fruit;
            break;
        }
    }
    if (existingFruit != null) {
        int quantity = validation.getIntAboveZeroFromInput("Quantity");
        existingFruit.setFquantity(existingFruit.getFquantity() + quantity);
        System.out.println("Quantity updated successfully for Fruit with ID: " + fruitId);
    } else {
        System.out.print("Enter Fruit Name: ");
        String fruitName = validation.getNonEmptyString("");

        double price = validation.getDoubleAboveZeroFromInput("Price");
        int quantity = validation.getIntAboveZeroFromInput("Quantity");

        scanner.nextLine();

        System.out.print("Enter Origin: ");
        String origin = validation.getNonEmptyString("");

        Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        fruits.add(fruit);
        System.out.println("Fruit created successfully.");
    }

    System.out.print("Do you want to continue (Y/N)? ");
    String choice = scanner.nextLine();
    if (choice.equalsIgnoreCase("N")) {
        displayAllFruits();
    }
}

    public void displayAllFruits() {
        System.out.println("All Fruits");
        System.out.println("+----------+----------+----------+----------+----------+");
        System.out.println("| Fruit ID | Fruit Name |  Origin  |  Price   | Quantity |");
        System.out.println("+----------+----------+----------+----------+----------+");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.showFruitManage());
        }
        System.out.println("+----------+----------+----------+----------+----------+");
    }

    public void displayAllFruitsForCustomer() {
        System.out.println("All Fruits");
        System.out.println("+----------+----------+----------+----------+");
        System.out.println("| Fruit ID | Fruit Name |  Origin  |  Price   |");
        System.out.println("+----------+----------+----------+----------+");
        for (Fruit fruit : fruits) {
            System.out.println(fruit.showFruitCustome());
        }
        System.out.println("+----------+----------+----------+----------+");
    }

    public void searchFruitById() {
        System.out.print("Enter Fruit ID: ");
        String fruitId = scanner.nextLine();

        for (Fruit fruit : fruits) {
            if (fruit.getFid().equalsIgnoreCase(fruitId)) {
                System.out.println("Fruit found:");
                System.out.println(fruit.showFruitManage());
                return;
            }
        }

        System.out.println("Fruit not found with the given ID.");
    }

    public void updateFruitQuantity() {
        System.out.print("Enter Fruit ID: ");
        String fruitId = scanner.nextLine();

        for (Fruit fruit : fruits) {
            if (fruit.getFid().equalsIgnoreCase(fruitId)) {
                int quantity = validation.getIntAboveZeroFromInput("Enter new quantity: ");
                fruit.setFquantity(quantity);
                System.out.println("Fruit quantity updated successfully.");
                return;
            }
        }

        System.out.println("Fruit not found with the given ID.");
    }

    public void removeFruit() {
        System.out.print("Enter Fruit ID: ");
        String fruitId = scanner.nextLine();

        for (Fruit fruit : fruits) {
            if (fruit.getFid().equalsIgnoreCase(fruitId)) {
                fruits.remove(fruit);
                System.out.println("Fruit removed successfully.");
                return;
            }
        }

        System.out.println("Fruit not found with the given ID.");
    }
    
}