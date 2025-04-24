package com.pluralsight;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mod03 {
    public static void main (String[] args) {

        //Current date and time
        LocalDateTime now = LocalDateTime.now();

        //Format 1 (MM/dd/yyyy)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate1 = now.format(formatter1);
        //print formatted date
        System.out.println("Formatted Date: " + formattedDate1);

        //Format 2 (yyyy-MM-dd)
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate2 = now.format(formatter2);
        //print formatted date
        System.out.println("Formatted Date: " + formattedDate2);

        //Format 3 (Full month, day, year)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate3 = now.format(formatter3);
        //print formatted date
        System.out.println("Formatted Date: " + formattedDate3);

        //Format 4 (Day, Month, year and time)
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        String formattedDate4 = now.format(formatter4);
        //print formatted date
        System.out.println("Formatted Date : " + formattedDate4);

        //Challenge Format ( time on DD,MMM,YYYY)
        DateTimeFormatter formatterchallenge = DateTimeFormatter.ofPattern("h:mm 'on' dd-MMM-yyyy");
        String formattedDate5 = now.format(formatterchallenge);
        System.out.println("Formatted Date: " + formattedDate5);



}
    }
