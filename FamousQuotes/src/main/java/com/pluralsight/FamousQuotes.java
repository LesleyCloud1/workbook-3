package com.pluralsight;

import java.util.Scanner;  // For reading user input
import java.util.Random;   // For generating random numbers

public class FamousQuotes {
    public static void main(String[] args) {
        // Create a scanner to get input from user
        Scanner scanner = new Scanner(System.in);

        // Create a random object to generate random quote indexes
        Random random = new Random();

        // Step 1: Create an array of 10 quotes
        String[] quotes = {
                "Fortune favors the bold. – Virgil",
                "I think, therefore I am. – René Descartes",
                "You miss 100% of the shots you don’t take. – Wayne Gretzky",
                "Be yourself; everyone else is already taken. – Oscar Wilde",
                "Tough times never last but tough people do. – Robert H. Schuller",
                "Time is money. – Benjamin Franklin",
                "The best and most beautiful things in the world cannot be seen or even touched—they must be felt with the heart. – Helen Keller",
                "Life is what happens when you’re busy making other plans. – John Lennon",
                "The purpose of our lives is to be happy. – Dalai Lama",
                "In the end, we only regret the chances we didn’t take. – Lewis Carroll"
        };

        // Step 2: Loop to let the user keep viewing quotes
        boolean keepGoing = true;

        while (keepGoing) {
            // Step 3: Ask user for input
            System.out.println("\nChoose a number (1–10) to see a quote, or type 'r' for a random quote:");
            String input = scanner.nextLine(); // Read user input as a String

            // Step 4: If user types 'r' → show random quote
            if (input.equalsIgnoreCase("r")) {
                int randomIndex = random.nextInt(quotes.length); // Pick a number between 0 and 9
                System.out.println("\n📜 Random Quote:");
                System.out.println(quotes[randomIndex]);
            }
            // Step 5: Else, try to convert input to a number and show quote
            else {
                try {
                    int choice = Integer.parseInt(input); // Convert input to integer

                    // Check if the number is within valid range (1–10)
                    if (choice >= 1 && choice <= 10) {
                        System.out.println("\n📜 Selected Quote:");
                        System.out.println(quotes[choice - 1]); // Subtract 1 for array index (starts at 0)
                    } else {
                        System.out.println("⚠️ That number is out of range. Please choose 1 to 10.");
                    }

                } catch (NumberFormatException e) {
                    // If user typed something that can't be a number (like "hello")
                    System.out.println("❌ Invalid input! Please enter a number between 1–10 or 'r' for random.");
                } catch (Exception e) {
                    // Catch any other unexpected errors
                    System.out.println("❌ Something went wrong: " + e.getMessage());
                }
            }

            // Step 6: Ask user if they want to try again
            System.out.print("\nWould you like to see another quote? (yes/no): ");
            String again = scanner.nextLine();

            // If the user doesn't say "yes", exit the loop
            if (!again.equalsIgnoreCase("yes")) {
                keepGoing = false;
            }
        }

        // Step 7: Exit message
        System.out.println("Goodbye! Have a great day.");
    }
}
