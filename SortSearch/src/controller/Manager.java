package controller;

import view.Menu;
import controller.InputParseException;
import model.Sort;
import java.util.Scanner;
import model.Search;

public class Manager extends Menu {
    private Scanner scanner;
    Sort sort = new Sort();
    Search search = new Search();
    public Manager() {
        super("Menu", new String[]{"Bubble Sort", "Quick Sort","Linear Search","Binary Search","Exit"});
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
                    sort.bubbleSort(arr);
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
                    sort.quickSort(arr2, 0, arr2.length - 1);
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
                float k=0;
                System.out.print("Enter the numbers (separated by spaces): ");
                input = scanner.nextLine();
                try {
                System.out.print("Enter the number need to search:");
                k = scanner.nextFloat();
                }
                catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    break;
                }
                try {
                    float[] arr2 = parseInput(input);
                    System.out.println("Performing Linear Search...");
                    search.Linearsearch(arr2,k);
                        
                } catch (InputParseException e) {
                    System.out.println("Invalid input. Please try again.");
                }
                break;
            case 4:
                float l=0;
                System.out.print("Enter the numbers (separated by spaces): ");
                input = scanner.nextLine();
                try {
                System.out.print("Enter the number need to search: ");
                l = scanner.nextFloat();
                }
                catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    break;
                }
                try {
                    float[] arr2 = parseInput(input);
                    System.out.println("Performing Binary Search...");
                    search.Linearsearch(arr2,l);
                    
                    
                } catch (InputParseException e) {
                    System.out.println("Invalid input. Please try again.");
                }
                break;
            case 5:
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