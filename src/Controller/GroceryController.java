/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GroceryItem;
import java.util.ArrayList;

/**
 * This controller handles all the grocery store operations
 * I've implemented CRUD, sorting, searching, queue and stack here
 * 
 * @author Saksham Kandel
 * @studentId 24046631
 */
public class GroceryController {
    
    // This is our main list where we store all grocery items
    private static ArrayList<GroceryItem> itemList = new ArrayList<GroceryItem>();
    
    // I'm using an array for the history stack with a top pointer
    private static final int STACK_MAX = 100;
    private static GroceryItem[] historyStack = new GroceryItem[STACK_MAX];
    private static int top = -1;
    
    // This queue stores the last 5 recently added items using front and rear
    private static final int QUEUE_SIZE = 5;
    private static GroceryItem[] recentQueue = new GroceryItem[QUEUE_SIZE];
    private static int front = -1;
    private static int rear = -1;
    
    // This flag makes sure we only load default data once
    private static boolean isInitialized = false;
    
    // Constructor - sets up the controller
    public GroceryController() {
        if (!isInitialized) {
            initializeDefaultData();
            isInitialized = true;
        }
    }
    
    // This loads 5 sample grocery items when the app starts (prices in NPR)
    private void initializeDefaultData() {
        itemList.add(new GroceryItem(101, "Apple", "Fruits", 50, 180.00));
        itemList.add(new GroceryItem(102, "Milk", "Dairy", 20, 85.00));
        itemList.add(new GroceryItem(103, "Bread", "Bakery", 15, 60.00));
        itemList.add(new GroceryItem(104, "Eggs", "Dairy", 100, 18.00));
        itemList.add(new GroceryItem(105, "Chicken", "Meat", 10, 450.00));
    }
    
    // This method adds a new item after checking for duplicates
    public boolean addItem(GroceryItem newItem) {
        // First check if the ID already exists
        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem item = itemList.get(i);
            if (item.getItemId() == newItem.getItemId()) {
                throw new IllegalArgumentException("Error: Item ID " + newItem.getItemId() + " already exists.");
            }
        }
        
        // Also check if the name is taken
        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem item = itemList.get(i);
            if (item.getName().equalsIgnoreCase(newItem.getName())) {
                throw new IllegalArgumentException("Error: Item Name '" + newItem.getName() + "' already exists.");
            }
        }
        
        // All good, add it to our list
        itemList.add(newItem);
        
        // Also put it in the recently added queue
        enqueue(newItem);
        
        return true;
    }
    
    // Returns all items in our inventory
    public ArrayList<GroceryItem> getAllItems() {
        return itemList;
    }
    
    // Updates an existing item with new values
    public void updateItem(GroceryItem updatedItem) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == updatedItem.getItemId()) {
                itemList.set(i, updatedItem);
                return;
            }
        }
        throw new IllegalArgumentException("Error: Item ID " + updatedItem.getItemId() + " not found for update.");
    }
    
    // Removes an item from our inventory
    public void deleteItem(int itemId) {
        int indexToRemove = -1;
        
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == itemId) {
                indexToRemove = i;
                break;
            }
        }
        
        if (indexToRemove != -1) {
            itemList.remove(indexToRemove);
        } else {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found for deletion.");
        }
    }
    
    // Checks if the queue has no items
    private boolean isQueueEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
    
    // Checks if the queue is at capacity
    private boolean isQueueFull() {
        int nextRear = (rear + 1) % QUEUE_SIZE;
        if (nextRear == front) {
            return true;
        }
        return false;
    }
    
    // Counts how many items are in the queue
    private int getQueueSize() {
        if (isQueueEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        }
        return QUEUE_SIZE - front + rear + 1;
    }
    
    // Adds an item to the back of the queue
    private void enqueue(GroceryItem item) {
        if (isQueueFull()) {
            dequeue();
        }
        
        if (front == -1) {
            front = 0;
        }
        
        rear = (rear + 1) % QUEUE_SIZE;
        recentQueue[rear] = item;
    }
    
    // Takes out the item from the front of the queue
    private GroceryItem dequeue() {
        if (isQueueEmpty()) {
            return null;
        }
        
        GroceryItem item = recentQueue[front];
        recentQueue[front] = null;
        
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % QUEUE_SIZE;
        }
        
        return item;
    }
    
    // Gets all the recently added items as a list
    public ArrayList<GroceryItem> getRecentlyAddedItems() {
        ArrayList<GroceryItem> recentItems = new ArrayList<GroceryItem>();
        
        if (isQueueEmpty()) {
            return recentItems;
        }
        
        int count = getQueueSize();
        int index = front;
        for (int i = 0; i < count; i++) {
            if (recentQueue[index] != null) {
                recentItems.add(recentQueue[index]);
            }
            index = (index + 1) % QUEUE_SIZE;
        }
        
        return recentItems;
    }
    
    // Checks if history stack is empty
    private boolean isStackEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
    
    // Puts an item on top of the history stack
    private void push(GroceryItem item) {
        if (top == STACK_MAX - 1) {
            System.out.println("History stack is full!");
            return;
        }
        top = top + 1;
        historyStack[top] = item;
    }
    
    // Gets all history items with most recent first
    public ArrayList<GroceryItem> getHistoryItems() {
        ArrayList<GroceryItem> historyItems = new ArrayList<GroceryItem>();
        
        for (int i = top; i >= 0; i--) {
            if (historyStack[i] != null) {
                historyItems.add(historyStack[i]);
            }
        }
        
        return historyItems;
    }
    
    // Handles when a user buys something
    public boolean processPurchase(int itemId, int quantity) {
        GroceryItem item = null;
        
        // Find the item
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == itemId) {
                item = itemList.get(i);
                break;
            }
        }
        
        if (item == null) {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found!");
        }
        
        if (quantity <= 0) {
            throw new IllegalArgumentException("Error: Quantity must be positive!");
        }
        
        if (item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Error: Insufficient stock! Available: " + item.getQuantity());
        }
        
        // Take the quantity out of stock
        int newQuantity = item.getQuantity() - quantity;
        item.setQuantity(newQuantity);
        
        // Make a record of what was purchased for history
        GroceryItem purchasedItem = new GroceryItem(
            item.getItemId(),
            item.getName(),
            item.getCategory(),
            quantity,
            item.getPrice()
        );
        
        // Add to history so we can track it
        push(purchasedItem);
        
        return true;
    }
    
    // Sorts items alphabetically by name using insertion sort
    public void insertionSortByName() {
        int n = itemList.size();
        
        for (int i = 1; i < n; i++) {
            GroceryItem key = itemList.get(i);
            int j = i - 1;
            
            while (j >= 0 && itemList.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                itemList.set(j + 1, itemList.get(j));
                j = j - 1;
            }
            itemList.set(j + 1, key);
        }
    }
    
    // Sorts by ID using selection sort
    public void selectionSortById() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getItemId() < itemList.get(minIndex).getItemId()) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                GroceryItem temp = itemList.get(minIndex);
                itemList.set(minIndex, itemList.get(i));
                itemList.set(i, temp);
            }
        }
    }
    
    // This finds all items that contain the search term
    public ArrayList<GroceryItem> linearSearchByNamePartial(String searchTerm) {
        ArrayList<GroceryItem> results = new ArrayList<GroceryItem>();
        String lowerSearchTerm = searchTerm.toLowerCase();
        
        for (int i = 0; i < itemList.size(); i++) {
            String itemName = itemList.get(i).getName().toLowerCase();
            if (itemName.indexOf(lowerSearchTerm) >= 0) {
                results.add(itemList.get(i));
            }
        }
        
        return results;
    }
    
    // Binary search finds items by ID quickly
    public GroceryItem binarySearchById(int targetId) {
        // First sort by ID
        selectionSortById();
        
        int low = 0;
        int high = itemList.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = itemList.get(mid).getItemId();
            
            if (midId == targetId) {
                return itemList.get(mid);
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return null;
    }
    
    // Calculates total quantity of all items in stock
    public int getTotalStockCount() {
        int total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            total = total + itemList.get(i).getQuantity();
        }
        return total;
    }
    
    // Calculates total monetary value of all inventory
    public double getTotalInventoryValue() {
        double total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem item = itemList.get(i);
            total = total + (item.getQuantity() * item.getPrice());
        }
        return total;
    }
}