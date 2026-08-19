package com.expensetracker;

import java.util.List;
//Testing for Poll SCM
public class ExpenseManager {

    private FileManager fileManager;

    // Constructor
    public ExpenseManager() {
        fileManager = new FileManager();
    }

    // Add a new expense
    public void addExpense(String date,
                           String category,
                           double amount,
                           String description) {

        Expense expense = new Expense(
                date,
                category,
                amount,
                description
        );

        fileManager.saveExpense(expense);
    }

    // Display expenses of a selected month
    public void showMonthlyExpenses(String month) {

        List<Expense> expenses =
                fileManager.readMonthlyExpenses(month);

        if (expenses.isEmpty()) {

            System.out.println("\nNo expenses found.");

            return;
        }

        System.out.println("\n-----------------------------------------------------------");
        System.out.printf("%-15s %-15s %-10s %-20s\n",
                "Date", "Category", "Amount", "Description");
        System.out.println("-----------------------------------------------------------");

        for (Expense expense : expenses) {

            System.out.printf("%-15s %-15s %-10.2f %-20s\n",

                    expense.getDate(),
                    expense.getCategory(),
                    expense.getAmount(),
                    expense.getDescription());

        }

        System.out.println("-----------------------------------------------------------");
    }

    // Calculate total expense for one month
    public void calculateMonthlyTotal(String month) {

        List<Expense> expenses =
                fileManager.readMonthlyExpenses(month);

        double total = 0;

        for (Expense expense : expenses) {

            total += expense.getAmount();

        }

        System.out.println("\nTotal Expense = ₹ " + total);
    }

    // Calculate total expense of all months
    public void calculateOverallTotal() {

        List<Expense> expenses =
                fileManager.readAllExpenses();

        double total = 0;

        for (Expense expense : expenses) {

            total += expense.getAmount();

        }

        System.out.println("\nOverall Expense = ₹ " + total);

    }

}