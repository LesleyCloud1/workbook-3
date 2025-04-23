package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class PayrollCalculator {
    public static void main(String[] args) {
        //Filename, this is where we are getting our employee details from.
        String fileName = "src/main/resources/employees.csv"; //Location of CSV file

        try {
            //Set up the BufferedReader to read the file line by line and store it in string line
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            //Skipping first line since theres no data just headers
            reader.readLine();

            //Reads each line of data, when you reach the end of the file, read line () returns null.
            while ((line = reader.readLine()) != null) {
                //Split each line into parts using the '|' character
                String[] parts = line.split("\\|");
                //Convert the string values to the correct data type
                int id = Integer.parseInt(parts[0]); // Convert ID to an integer
                String name = parts[1]; //Name is string
                double hours = Double.parseDouble(parts[2]); //Hours worked
                double rate = Double.parseDouble(parts[3]); //Pay rate

                //Create an Employee object using the data we just parsed
                Employee emp = new Employee(id, name, hours, rate);

                // Print out the employee's info
                System.out.printf("Id: %d | Name: %-20s | Gross Pay: $%.2f%n", //integer, string and number with 2 decimal
                        emp.getEmployeeId(), emp.getName(), emp.getGrossPay());

            }

            reader.close();

        } catch (Exception e) {
            // Catch any kind of error, if unable to locate file or any data error
            System.out.println("Error, there was a problem reading the file or data.");
        }
    }
}