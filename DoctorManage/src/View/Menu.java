package View;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private String title;
    private ArrayList<String> menuChoices;

    public Menu(String title, String[] menuChoices) {
        this.title = title;
        this.menuChoices = new ArrayList<>();
        for (String choice : menuChoices) {
            this.menuChoices.add(choice);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("-------------------------------------");
        for (int i = 0; i < menuChoices.size(); i++) {
            System.out.println((i + 1) + ". " + menuChoices.get(i));
        }
        System.out.println("-------------------------------------");
    }

    public int getSelectedChoice() {
        display();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public String getInputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public int getInputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}