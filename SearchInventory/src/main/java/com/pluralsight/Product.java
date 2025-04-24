package com.pluralsight;

// This class represents a product with SKU, name, price, and department.
public class Product {

    // Fields (also called instance variables)
    private String sku;        // Unique product code (e.g., "AV1051")
    private String name;       // Name of the product
    private float price;       // Price of the product
    private String department; // Department the product belongs to

    // Constructor — runs when we create a new Product object
    public Product(String sku, String name, float price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Getter methods — used to access private fields from outside the class
    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }
}
