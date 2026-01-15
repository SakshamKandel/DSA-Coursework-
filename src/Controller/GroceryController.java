/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.GroceryItem;
import java.util.ArrayList;

/**
 * GroceryController - Complete Controller for DSA Coursework
 * Contains all CRUD operations, data structures, sorting, and searching algorithms
 * 
 * @author Saksham Kandel
 * @studentId 24046631
 */
public class GroceryController {
    
    // Main ArrayList for inventory storage
    private static ArrayList<GroceryItem> itemList = new ArrayList<>();
    
    // Stack for History using array with top variable
    private static final int STACK_MAX = 100;
    private static GroceryItem[] historyStack = new GroceryItem[STACK_MAX];
    private static int top = -1;
    
    // Queue for Recently Added using array with front and rear variables
    private static final int QUEUE_SIZE = 5;
    private static GroceryItem[] recentQueue = new GroceryItem[QUEUE_SIZE];
    private static int front = -1;
    private static int rear = -1;
    
    // Flag to check if default data is already loaded
    private static boolean isInitialized = false;
    
    // Constructor
    public GroceryController() {
        // Load default data only once
        if (!isInitialized) {
            initializeDefaultData();
            isInitialized = true;
        }
    }
    
    // Load 5 default grocery items as per requirement
    private void initializeDefaultData() {
        itemList.add(new GroceryItem(101, "Apple", "Fruits", 50, 0.50));
        itemList.add(new GroceryItem(102, "Milk", "Dairy", 20, 1.20));
        itemList.add(new GroceryItem(103, "Bread", "Bakery", 15, 2.00));
        itemList.add(new GroceryItem(104, "Eggs", "Dairy", 100, 0.10));
        itemList.add(new GroceryItem(105, "Chicken", "Meat", 10, 5.50));
    }
    
    // ---------------------- CRUD OPERATIONS ----------------------
    
    // Add new item with validation for duplicate ID and Name
    public boolean addItem(GroceryItem newItem) {
        // Check for duplicate ID
        for (GroceryItem item : itemList) {
            if (item.getItemId() == newItem.getItemId()) {
                throw new IllegalArgumentException("Error: Item ID " + newItem.getItemId() + " already exists.");
            }
        }
        
        // Check for duplicate Name
        for (GroceryItem item : itemList) {
            if (item.getName().equalsIgnoreCase(newItem.getName())) {
                throw new IllegalArgumentException("Error: Item Name '" + newItem.getName() + "' already exists.");
            }
        }
        
        // Add to main list
        itemList.add(newItem);
        
        // Also add to recently added queue
        enqueue(newItem);
        
        return true;
    }
    
    // Get all items
    public ArrayList<GroceryItem> getAllItems() {
        return itemList;
    }
    
    // Get item by ID
    public GroceryItem getItemById(int itemId) {
        for (GroceryItem item : itemList) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }
    
    // Update existing item
    public void updateItem(GroceryItem updatedItem) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == updatedItem.getItemId()) {
                itemList.set(i, updatedItem);
                return;
            }
        }
        throw new IllegalArgumentException("Error: Item ID " + updatedItem.getItemId() + " not found for update.");
    }
    
    // Delete item by ID
    public void deleteItem(int itemId) {
        boolean removed = itemList.removeIf(item -> item.getItemId() == itemId);
        if (!removed) {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found for deletion.");
        }
    }
    
    // ---------------------- QUEUE OPERATIONS (Recently Added) ----------------------
    // Using array-based queue with front and rear pointers
    
    // Check if queue is empty
    public boolean isQueueEmpty() {
        return front == -1;
    }
    
    // Check if queue is full
    public boolean isQueueFull() {
        return (rear + 1) % QUEUE_SIZE == front;
    }
    
    // Get current queue size
    public int getQueueSize() {
        if (isQueueEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        }
        return QUEUE_SIZE - front + rear + 1;
    }
    
    // Enqueue - add item to rear of queue
    public void enqueue(GroceryItem item) {
        // If queue is full, remove oldest item first (dequeue)
        if (isQueueFull()) {
            dequeue();
        }
        
        // If queue is empty, set front to 0
        if (front == -1) {
            front = 0;
        }
        
        // Move rear circularly and add item
        rear = (rear + 1) % QUEUE_SIZE;
        recentQueue[rear] = item;
    }
    
    // Dequeue - remove item from front of queue
    public GroceryItem dequeue() {
        if (isQueueEmpty()) {
            return null;
        }
        
        GroceryItem item = recentQueue[front];
        recentQueue[front] = null;
        
        // If only one element was present
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move front circularly
            front = (front + 1) % QUEUE_SIZE;
        }
        
        return item;
    }
    
    // Peek front element without removing
    public GroceryItem peekQueue() {
        if (isQueueEmpty()) {
            return null;
        }
        return recentQueue[front];
    }
    
    // Get all items from queue as ArrayList
    public ArrayList<GroceryItem> getRecentlyAddedItems() {
        ArrayList<GroceryItem> recentItems = new ArrayList<>();
        
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
    
    // ---------------------- STACK OPERATIONS (History) ----------------------
    // Using array-based stack with top variable
    
    // Check if stack is empty
    public boolean isStackEmpty() {
        return top == -1;
    }
    
    // Check if stack is full
    public boolean isStackFull() {
        return top == STACK_MAX - 1;
    }
    
    // Get current stack size
    public int getStackSize() {
        return top + 1;
    }
    
    // Push - add item to top of stack
    public void push(GroceryItem item) {
        if (isStackFull()) {
            System.out.println("History stack is full!");
            return;
        }
        top++;
        historyStack[top] = item;
    }
    
    // Pop - remove and return top item from stack
    public GroceryItem pop() {
        if (isStackEmpty()) {
            return null;
        }
        GroceryItem item = historyStack[top];
        historyStack[top] = null;
        top--;
        return item;
    }
    
    // Peek top element without removing
    public GroceryItem peekStack() {
        if (isStackEmpty()) {
            return null;
        }
        return historyStack[top];
    }
    
    // Get all items from stack as ArrayList (most recent first)
    public ArrayList<GroceryItem> getHistoryItems() {
        ArrayList<GroceryItem> historyItems = new ArrayList<>();
        
        // Add from top to bottom (most recent first)
        for (int i = top; i >= 0; i--) {
            if (historyStack[i] != null) {
                historyItems.add(historyStack[i]);
            }
        }
        
        return historyItems;
    }
    
    // Process a purchase - reduces stock and adds to history stack
    public boolean processPurchase(int itemId, int quantity) {
        GroceryItem item = linearSearchById(itemId);
        
        if (item == null) {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found!");
        }
        
        if (quantity <= 0) {
            throw new IllegalArgumentException("Error: Quantity must be positive!");
        }
        
        if (item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Error: Insufficient stock! Available: " + item.getQuantity());
        }
        
        // Reduce item quantity
        item.setQuantity(item.getQuantity() - quantity);
        
        // Create a copy for history with purchased quantity
        GroceryItem purchasedItem = new GroceryItem(
            item.getItemId(),
            item.getName(),
            item.getCategory(),
            quantity,  // Store purchased quantity
            item.getPrice()
        );
        
        // Push to history stack
        push(purchasedItem);
        
        return true;
    }
    
    // ---------------------- SORTING ALGORITHMS ----------------------
    
    // Insertion Sort by Name (Alphabetical A-Z)
    // Builds sorted array one element at a time by inserting each element in correct position
    public void insertionSortByName() {
        int n = itemList.size();
        
        for (int i = 1; i < n; i++) {
            GroceryItem key = itemList.get(i);
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && itemList.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                itemList.set(j + 1, itemList.get(j));
                j = j - 1;
            }
            itemList.set(j + 1, key);
        }
    }
    
    // Insertion Sort by Price (Low to High)
    public void insertionSortByPrice() {
        int n = itemList.size();
        
        for (int i = 1; i < n; i++) {
            GroceryItem key = itemList.get(i);
            int j = i - 1;
            
            while (j >= 0 && itemList.get(j).getPrice() > key.getPrice()) {
                itemList.set(j + 1, itemList.get(j));
                j = j - 1;
            }
            itemList.set(j + 1, key);
        }
    }
    
    // Insertion Sort by Quantity (Low to High)
    public void insertionSortByQuantity() {
        int n = itemList.size();
        
        for (int i = 1; i < n; i++) {
            GroceryItem key = itemList.get(i);
            int j = i - 1;
            
            while (j >= 0 && itemList.get(j).getQuantity() > key.getQuantity()) {
                itemList.set(j + 1, itemList.get(j));
                j = j - 1;
            }
            itemList.set(j + 1, key);
        }
    }
    
    // Selection Sort by ID (Ascending)
    // Finds minimum element in unsorted portion and swaps with first unsorted element
    public void selectionSortById() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element index in unsorted portion
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getItemId() < itemList.get(minIndex).getItemId()) {
                    minIndex = j;
                }
            }
            
            // Swap if minimum is not at current position
            if (minIndex != i) {
                GroceryItem temp = itemList.get(minIndex);
                itemList.set(minIndex, itemList.get(i));
                itemList.set(i, temp);
            }
        }
    }
    
    // Selection Sort by Name (Alphabetical A-Z)
    public void selectionSortByName() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getName().compareToIgnoreCase(itemList.get(minIndex).getName()) < 0) {
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
    
    // Selection Sort by Price (Low to High)
    public void selectionSortByPrice() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getPrice() < itemList.get(minIndex).getPrice()) {
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
    
    // Selection Sort by Quantity (Low to High)
    public void selectionSortByQuantity() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getQuantity() < itemList.get(minIndex).getQuantity()) {
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
    
    // ---------------------- SEARCHING ALGORITHMS ----------------------
    
    // Linear Search by ID
    // Sequentially checks each element until match is found
    public GroceryItem linearSearchById(int targetId) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == targetId) {
                return itemList.get(i);
            }
        }
        return null;
    }
    
    // Linear Search by Name (exact match, case-insensitive)
    public GroceryItem linearSearchByName(String targetName) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equalsIgnoreCase(targetName)) {
                return itemList.get(i);
            }
        }
        return null;
    }
    
    // Linear Search by Name (partial match for search-as-you-type)
    // Returns all items containing the search term
    public ArrayList<GroceryItem> linearSearchByNamePartial(String searchTerm) {
        ArrayList<GroceryItem> results = new ArrayList<>();
        String lowerSearchTerm = searchTerm.toLowerCase();
        
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().toLowerCase().contains(lowerSearchTerm)) {
                results.add(itemList.get(i));
            }
        }
        
        return results;
    }
    
    // Binary Search by ID
    // Requires sorted data - divides search interval in half repeatedly
    public GroceryItem binarySearchById(int targetId) {
        // Sort by ID first as binary search requires sorted data
        selectionSortById();
        
        int low = 0;
        int high = itemList.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevents overflow
            int midId = itemList.get(mid).getItemId();
            
            if (midId == targetId) {
                return itemList.get(mid);
            } else if (midId < targetId) {
                low = mid + 1;  // Search right half
            } else {
                high = mid - 1;  // Search left half
            }
        }
        
        return null;
    }
    
    // Binary Search by Name (Alphabetical)
    public GroceryItem binarySearchByName(String targetName) {
        // Sort by Name first
        insertionSortByName();
        
        int low = 0;
        int high = itemList.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midName = itemList.get(mid).getName();
            int comparison = midName.compareToIgnoreCase(targetName);
            
            if (comparison == 0) {
                return itemList.get(mid);
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return null;
    }
    
    // ---------------------- UTILITY METHODS ----------------------
    
    // Get total inventory value (sum of quantity * price)
    public double getTotalInventoryValue() {
        double total = 0;
        for (GroceryItem item : itemList) {
            total += item.getQuantity() * item.getPrice();
        }
        return total;
    }
    
    // Get total stock count
    public int getTotalStockCount() {
        int total = 0;
        for (GroceryItem item : itemList) {
            total += item.getQuantity();
        }
        return total;
    }
    
    // Get total number of unique items
    public int getTotalItemCount() {
        return itemList.size();
    }
}