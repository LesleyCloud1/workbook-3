package com.pluralsight;

import java.io.BufferedReader; //Allows to read text line by line from a file
import java.io.FileReader; //Open file, always run with buffer reader to get contents of file
import java.util.ArrayList; //Use ArrayList class to store all the products from inventory
import java.util.Collections;//To sort all the products from your inventory
import java.util.Comparator;//Sorts products by alphabetical order
import java.util.Scanner;//User input

public class StoreApp {

    public static void main(String[] args) {

        //Load products from the product file
        ArrayList<Product> inventory = getInventoryFromFile();

        //Start scanner to get user input
        Scanner scanner = new Scanner(System.in);

        //Output to user
        System.out.println("We carry the following inventory: ");

        //Loop over our products and display them
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("SKU:%s | Product Name: %s - Price: $%.2f\n", p.getSku(), p.getName(), p.getPrice());
        }

        /*
        //getInventory method to get products
        ArrayList<Product> inventory = getInventory();
        */

        //^^This method manually added products to the list.
        //We’re not using it anymore since we're reading from file.
    }

    //Format of file using pipe split: id|name|price
    public static ArrayList<Product> getInventoryFromFile() {
        ArrayList<Product> inventory = new ArrayList<>();

        try {
            // Read from the file
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/products.csv"));
            reader.readLine(); //Skips first line (header)

            String line;
            while ((line = reader.readLine()) != null) {
                //Split the line into parts at the pipe | symbol
                String[] parts = line.split("\\|");

                //Make sure we got exactly 4 parts
                if (parts.length == 4) {
                    String sku = (parts[0]);
                    //int id = Integer.parseInt(parts[1]);       //Convert ID to int
                    String name = parts[1];                    //Product name stays string
                    float price = Float.parseFloat(parts[2]);//Convert price to float or double
                    String department = parts[3];
                    //Create the Product object
                    Product product = new Product(sku, name, price, department);
                    inventory.add(product); // Add to list
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }

            reader.close(); //Always close the file after reading

            //Sort products alphabetically by name
            Collections.sort(inventory, Comparator.comparing(Product::getName));

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return inventory;
    }
}
