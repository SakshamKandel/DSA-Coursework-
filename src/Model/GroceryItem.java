/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class GroceryItem {
    
    // Attributes
    private int itemId;         // Unique ID for Binary Search
    private String name;        // Product name for Linear Search
    private String category;    // e.g., "Dairy", "Snacks"
    private int quantity;       // Stock level (must be non-negative) 
    private double price;       // Price per unit
    
    // Constructor
    public GroceryItem(int itemId, String name, String category, int quantity, double price) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    // Validation logic can be added here or in the Controller
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            // Requirement: Prevent entering negative numbers 
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    // toString method for easy debugging/printing
    @Override
    public String toString() {
        return "ID: " + itemId + " | Name: " + name + " | Category: " + category + 
               " | Qty: " + quantity + " | Price: " + price;
    }
}