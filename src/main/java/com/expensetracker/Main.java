package com.expensetracker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ExpenseManager expenseManager = new ExpenseManager();
        SearchManager searchManager = new SearchManager();

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("         EXPENSE TRACKER");
            System.out.println("======================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Monthly Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Monthly Total");
            System.out.println("5. Overall Total");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Date (yyyy-MM-dd): ");
                    String date = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    expenseManager.addExpense(
                            date,
                            category,
                            amount,
                            description
                    );

                    break;

                case 2:

                    System.out.print("Enter Month (yyyy-MM): ");
                    String month = sc.nextLine();

                    expenseManager.showMonthlyExpenses(month);

                    break;

                case 3:

                    System.out.print("Enter Category: ");
                    String searchCategory = sc.nextLine();

                    searchManager.searchByCategory(searchCategory);

                    break;

                case 4:

                    System.out.print("Enter Month (yyyy-MM): ");
                    String totalMonth = sc.nextLine();

                    expenseManager.calculateMonthlyTotal(totalMonth);

                    break;

                case 5:

                    expenseManager.calculateOverallTotal();

                    break;

                case 6:

                    System.out.println("\nThank You for using Expense Tracker.");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

        sc.close();

    }

}