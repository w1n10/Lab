package Controller;

import Model.Expense;
import Model.Expense_Extension;
import View.Menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExpenseManage extends Menu {
    private Expense_Extension controller;
    private Scanner scanner;

    public ExpenseManage() {
        super("======= Handy Expense =======", new String[]{"Add an expense", "Display all expenses", "Delete an expense", "Quit"});
        controller = new Expense_Extension();
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                addExpense();
                break;
            case 2:
                displayAllExpenses();
                break;
            case 3:
                deleteExpense();
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private void addExpense() {
        System.out.println("-- Add an expense --");
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Expense not added.");
            return;
        }

        Expense expense = new Expense(controller.getExpenses().size() + 1, date, amount, content);
        controller.addExpense(expense);

        System.out.println("Expense added successfully.");
    }

    private void displayAllExpenses() {
        System.out.println("-- Display all expenses --");
        for (Expense expense : controller.getExpenses()) {
            System.out.println("ID: " + expense.getId());
            System.out.println("Date: " + expense.getDate());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Content: " + expense.getContent());
            System.out.println();
        }
    }

    private void deleteExpense() {
        System.out.println("-- Delete an expense --");
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controller.deleteExpense(id);
        System.out.println("Expense deleted successfully.");
    }
}