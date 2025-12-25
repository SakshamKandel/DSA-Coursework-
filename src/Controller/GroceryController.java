/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Acer
 */
import Model.GroceryItem;
import java.util.ArrayList;
import java.util.List;

/**
 * GroceryController
 * Manages the logic for adding, updating, and deleting items.
 * Implements MVC by separating logic from the View.
 */
public class GroceryController {
    
    // In-memory list to store items (acts as a temporary database)
    private ArrayList<GroceryItem> itemList;

    public GroceryController() {
        this.itemList = new ArrayList<>();
        
        // ✅ REQUIREMENT: Load 5 dummy data when initializing
        initializeDefaultData();
    }

    /**
     * Loads 5 default grocery items into the system.
     */
    private void initializeDefaultData() {
        itemList.add(new GroceryItem(101, "Apple", "Fruits", 50, 0.50));
        itemList.add(new GroceryItem(102, "Milk", "Dairy", 20, 1.20));
        itemList.add(new GroceryItem(103, "Bread", "Bakery", 15, 2.00));
        itemList.add(new GroceryItem(104, "Eggs", "Dairy", 100, 0.10));
        itemList.add(new GroceryItem(105, "Chicken", "Meat", 10, 5.50));
    }

    
    public boolean addItem(GroceryItem newItem) {
        
        // 1. Check for Duplicate ID (Coursework Requirement)
        for (GroceryItem item : itemList) {
            if (item.getItemId() == newItem.getItemId()) {
                throw new IllegalArgumentException("Error: Item ID " + newItem.getItemId() + " already exists.");
            }
        }
        
        // 2. Check for Duplicate Name (Coursework Requirement)
        for (GroceryItem item : itemList) {
            if (item.getName().equalsIgnoreCase(newItem.getName())) {
                throw new IllegalArgumentException("Error: Item Name '" + newItem.getName() + "' already exists.");
            }
        }

        // If checks pass, add to list
        return itemList.add(newItem);
    }

    /**
     * Updates an existing item in the list.
     * @param updatedItem The GroceryItem object with updated values.
     * @throws IllegalArgumentException if the item ID is not found.
     */
    public void updateItem(GroceryItem updatedItem) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == updatedItem.getItemId()) {
                itemList.set(i, updatedItem); // Replace old item with new one
                return;
            }
        }
        throw new IllegalArgumentException("Error: Item ID " + updatedItem.getItemId() + " not found for update.");
    }

    /**
     * Deletes an item from the list by ID.
     * @param itemId The ID of the item to delete.
     * @throws IllegalArgumentException if the item ID is not found.
     */
    public void deleteItem(int itemId) {
        boolean removed = itemList.removeIf(item -> item.getItemId() == itemId);
        if (!removed) {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found for deletion.");
        }
    }

    // Getter to retrieve the list (useful for populating the Table later)
    public ArrayList<GroceryItem> getAllItems() {
        return itemList;
    }
}