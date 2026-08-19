package com.expensetracker;

import java.util.List;

public class SearchManager {

    private FileManager fileManager;

    public SearchManager() {
        fileManager = new FileManager();
    }

    // Search expenses by category
    public void searchByCategory(String category) {

        List<Expense> expenses = fileManager.readAllExpenses();

        boolean found = false;
        double total = 0;

        System.out.println("\n============== SEARCH RESULT ==============");

        System.out.printf("%-15s %-15s %-10s %-20s\n",
                "Date", "Category", "Amount", "Description");

        System.out.println("-----------------------------------------------");

        for (Expense expense : expenses) {

            if (expense.getCategory().equalsIgnoreCase(category)) {

                System.out.printf("%-15s %-15s %-10.2f %-20s\n",

                        expense.getDate(),
                        expense.getCategory(),
                        expense.getAmount(),
                        expense.getDescription());

                total += expense.getAmount();

                found = true;

            }

        }

        if (!found) {

            System.out.println("No expenses found for category : " + category);

        } else {

            System.out.println("-----------------------------------------------");

            System.out.println("Total spent on "
                    + category + " = ₹ " + total);

        }

    }

}