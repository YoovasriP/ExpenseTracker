package com.expensetracker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // Folder where all expense files are stored
    private static final String FOLDER_NAME = "expenses";

    // Constructor
    public FileManager() {
        File folder = new File(FOLDER_NAME);

        // Create folder if it doesn't exist
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    // Returns file name based on month
    // Example: 2026-08-04 -> expenses/2026-08.txt
    private String getFileName(String date) {

        String month = date.substring(0, 7);

        return FOLDER_NAME + File.separator + month + ".txt";
    }

    // Save expense into corresponding monthly file
    public void saveExpense(Expense expense) {

        String fileName = getFileName(expense.getDate());

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(fileName, true))) {

            writer.write(expense.toString());
            writer.newLine();

            System.out.println("Expense Saved Successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving expense.");
            e.printStackTrace();
        }
    }

    // Read all expenses of a month
    // Example input : 2026-08
    public List<Expense> readMonthlyExpenses(String month) {

        List<Expense> expenses = new ArrayList<>();

        String fileName = FOLDER_NAME + File.separator + month + ".txt";

        File file = new File(fileName);

        if (!file.exists()) {

            System.out.println("No expenses found.");

            return expenses;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Expense expense = new Expense(

                        data[0],
                        data[1],
                        Double.parseDouble(data[2]),
                        data[3]

                );

                expenses.add(expense);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        return expenses;
    }

    // Read all expenses from every month
    public List<Expense> readAllExpenses() {

        List<Expense> allExpenses = new ArrayList<>();

        File folder = new File(FOLDER_NAME);

        File[] files = folder.listFiles();

        if (files == null) {

            return allExpenses;
        }

        for (File file : files) {

            try (BufferedReader reader =
                         new BufferedReader(new FileReader(file))) {

                String line;

                while ((line = reader.readLine()) != null) {

                    String[] data = line.split(",");

                    Expense expense = new Expense(

                            data[0],
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]

                    );

                    allExpenses.add(expense);

                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return allExpenses;
    }

}