package com.pluralsight;

import java.io.InputStream;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Show story choices
        System.out.println("Choose a bedtime story:");
        System.out.println("1. Goldilocks and the Three Bears");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary Had a Little Lamb");

        System.out.print("Enter the number of the story you want to read (1-3): ");
        int choice = input.nextInt();
        input.nextLine(); // Consume leftover newline

        String fileName = "";
        if (choice == 1) fileName = "goldilocks.txt";
        else if (choice == 2) fileName = "hansel_and_gretel.txt";
        else if (choice == 3) fileName = "mary_had_a_little_lamb.txt";
        else {
            System.out.println("Invalid selection.");
            return;
        }

        // Load file from resources folder
        InputStream inputStream = BedtimeStories.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            System.out.println(" Could not find the file: " + fileName);
            return;
        }

        // Read and print with line numbers
        Scanner fileScanner = new Scanner(inputStream);
        int lineNumber = 1;

        System.out.println("\n Your story begins:\n");
        while (fileScanner.hasNextLine()) {
            System.out.println(lineNumber + ". " + fileScanner.nextLine());
            lineNumber++;
        }

        fileScanner.close();
    }
}