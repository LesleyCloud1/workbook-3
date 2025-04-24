package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;//Local date and time
import java.time.format.DateTimeFormatter;//Date format tool since we are outputing the timestamp
import java.util.Scanner;
import java.time.Duration; //new tool found online to help calculate time spent inside application

public class SearchEngineLogger {
    static DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static Scanner theScanner = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.now();
        logActions("App launched started at: " + startTime.format(timeStampFormatter));
        //Loop to let the user enter actions
        boolean appRunning = true;

        while (appRunning) {
            System.out.print("Enter a search term (or type 'exit' to quit): ");
            String searchTerm = theScanner.nextLine();

            if (searchTerm.equalsIgnoreCase("exit")) {
                appRunning = false;
                LocalDateTime endTime = LocalDateTime.now();
                logActions("User exited at: " + endTime.format(timeStampFormatter));

                Duration duration = Duration.between(startTime, endTime); /*calculates the difference between when app
                started and ended, saved inside duration*/
                long minutes = duration.toMinutes();//calculates how many full minutes are in that duration
                long seconds = duration.getSeconds() % 60;/*calculates the leftover seconds after the full minutes, %
                modulus gives the remainder after dividing by 60, this line just gives seconds.*/

                String timeSpent = "Total time spent in app: " + minutes + " minutes and " + seconds + " seconds.";
                System.out.println(timeSpent);
                logActions(timeSpent);


            } else {
                //Log the search term to the log file
                logActions("search: " + searchTerm);
            }
        }
    }

    //Declaration of actions
    public static void logActions(String theAction) {
        try {
            //Create file writer in append mode
            FileWriter outPutFile = new FileWriter("src/main/resources/logs.txt", true);
            BufferedWriter bufWriter = new BufferedWriter(outPutFile);

            //Get the current date and time
            LocalDateTime timeStamp = LocalDateTime.now();

            //Format and write the log entry
            bufWriter.write(timeStamp.format(timeStampFormatter) + " " + theAction);
            bufWriter.newLine(); // Add a newline for each entry
            bufWriter.close(); // Always close the writer

        } catch (Exception e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
