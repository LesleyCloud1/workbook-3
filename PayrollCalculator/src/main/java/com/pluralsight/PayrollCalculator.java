package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //To get input from user

        //Show only one file option
        System.out.println("Choose an employee file to process:");
        System.out.println("1. employees.csv");
        System.out.print("Enter your only choice (1): ");
        int inputChoice = scanner.nextInt();
        scanner.nextLine();

        String inputFile;
        if (inputChoice == 1) {
            inputFile = "src/main/resources/employees.csv";
        } else {
            System.out.println("Defaulting to employees.csv.");
            inputFile = "src/main/resources/employees.csv";
        }

        //Ask for output file name
        System.out.println("\nChoose a payroll output file:");
        System.out.println("1. payroll-sept-2023.csv");
        System.out.print("Enter your only choice (1): ");
        int outputChoice = scanner.nextInt();
        scanner.nextLine();

        String outputFile;
        if (outputChoice == 1) {
            outputFile = "src/main/resources/payroll-sept-2023.csv";
        } else {
            System.out.println("Defaulting to payroll-sept-2023.csv.");
            outputFile = "src/main/resources/payroll-sept-2023.csv";
        }

        try {
            // Set up file readers/writers
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;

            //Skip headers in original input file, were only gathering data
            reader.readLine();

            //Write new header to new output file
            writer.write("Id|Name|Gross Pay");
            writer.newLine();

            // Read and process each line of employee data
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);

                Employee emp = new Employee(id, name, hours, rate);

                // Print to screen
                System.out.printf("Id: %d | Name: %-20s | Gross Pay: $%.2f%n",
                        emp.getEmployeeId(), emp.getName(), emp.getGrossPay());

                // Write to file
                writer.write(emp.getEmployeeId() + "|" + emp.getName() + "|" +
                        String.format("%.2f", emp.getGrossPay()));
                writer.newLine();
            }

            // Close both files
            reader.close();
            writer.close();

            System.out.println("New Payroll file created: " + outputFile);

        } catch (Exception e) {
            System.out.println("There was a problem reading, writing or locating the file.");
        }
    }
}
