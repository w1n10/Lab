package Model;

import java.util.ArrayList;
import java.util.List;

public class Expense_Extension {
    private List<Expense> expenses;

    public Expense_Extension() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void deleteExpense(int id) {
        expenses.removeIf(expense -> expense.getId() == id);
    }
}