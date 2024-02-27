package controler;

import view.Menu;
import Model.Sort;
import Model.InputParseException;

import java.util.Scanner;

public class ElementEntity extends Menu {
    private Scanner scanner;

    public ElementEntity() {
        super("Menu", new String[]{"Bubble Sort", "Quick Sort","Exit"});
        scanner = new Scanner(System.in);
    }

    public void execute(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter the numbers (separated by spaces): ");
                String input = scanner.nextLine();
                try {
                    float[] arr = parseInput(input);
                    System.out.println("Performing Bubble Sort...");
                    Sort.bubbleSort(arr);
                    System.out.print("Sorted array: ");
                    for (float num : arr) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                } catch (InputParseException e) {
                    System.out.println("Invalid input. Please try again.");
                }
                break;
            case 2:
                System.out.print("Enter the numbers (separated by spaces): ");
                input = scanner.nextLine();
                try {
                    float[] arr2 = parseInput(input);
                    System.out.println("Performing Quick Sort...");
                    Sort.quickSort(arr2, 0, arr2.length - 1);
                    System.out.print("Sorted array: ");
                    for (float num : arr2) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                } catch (InputParseException e) {
                    System.out.println("Invalid input. Please try again.");
                }
                break;
             case 3:
            System.out.println("Exiting...");
            System.exit(0);
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private float[] parseInput(String input) throws InputParseException {
        String[] numbers = input.split(" ");
        float[] arr = new float[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Float.parseFloat(numbers[i]);
            }
            return arr;
        } catch (NumberFormatException e) {
            throw new InputParseException("Invalid input format");
        }
    }
}