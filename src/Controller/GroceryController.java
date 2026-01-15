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
        // We only want to load the sample data the first time
        if (!isInitialized) {
            initializeDefaultData();
            isInitialized = true;
        }
    }
    
    // This loads 5 sample grocery items when the app starts
    private void initializeDefaultData() {
        itemList.add(new GroceryItem(101, "Apple", "Fruits", 50, 0.50));
        itemList.add(new GroceryItem(102, "Milk", "Dairy", 20, 1.20));
        itemList.add(new GroceryItem(103, "Bread", "Bakery", 15, 2.00));
        itemList.add(new GroceryItem(104, "Eggs", "Dairy", 100, 0.10));
        itemList.add(new GroceryItem(105, "Chicken", "Meat", 10, 5.50));
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
    
    // Finds an item by its ID
    public GroceryItem getItemById(int itemId) {
        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem item = itemList.get(i);
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
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
    
    // Removes an item from our inventory using a simple loop
    public void deleteItem(int itemId) {
        int indexToRemove = -1;
        
        // Find the index of the item to delete
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == itemId) {
                indexToRemove = i;
                break;
            }
        }
        
        // Remove if found
        if (indexToRemove != -1) {
            itemList.remove(indexToRemove);
        } else {
            throw new IllegalArgumentException("Error: Item ID " + itemId + " not found for deletion.");
        }
    }
    
    // Checks if the queue has no items
    public boolean isQueueEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
    
    // Checks if the queue is at capacity
    public boolean isQueueFull() {
        int nextRear = (rear + 1) % QUEUE_SIZE;
        if (nextRear == front) {
            return true;
        }
        return false;
    }
    
    // Counts how many items are in the queue right now
    public int getQueueSize() {
        if (isQueueEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        }
        return QUEUE_SIZE - front + rear + 1;
    }
    
    // Adds an item to the back of the queue
    public void enqueue(GroceryItem item) {
        // If queue is full, we remove the oldest one first
        if (isQueueFull()) {
            dequeue();
        }
        
        // Handle the case when queue was empty
        if (front == -1) {
            front = 0;
        }
        
        // Put the item at the rear position
        rear = (rear + 1) % QUEUE_SIZE;
        recentQueue[rear] = item;
    }
    
    // Takes out the item from the front of the queue
    public GroceryItem dequeue() {
        if (isQueueEmpty()) {
            return null;
        }
        
        GroceryItem item = recentQueue[front];
        recentQueue[front] = null;
        
        // Check if this was the last item
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move front to the next position
            front = (front + 1) % QUEUE_SIZE;
        }
        
        return item;
    }
    
    // Lets us see the front item without removing it
    public GroceryItem peekQueue() {
        if (isQueueEmpty()) {
            return null;
        }
        return recentQueue[front];
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
    public boolean isStackEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }
    
    // Checks if we've hit the stack limit
    public boolean isStackFull() {
        if (top == STACK_MAX - 1) {
            return true;
        }
        return false;
    }
    
    // Returns number of items in history
    public int getStackSize() {
        return top + 1;
    }
    
    // Puts an item on top of the history stack
    public void push(GroceryItem item) {
        if (isStackFull()) {
            System.out.println("History stack is full!");
            return;
        }
        top = top + 1;
        historyStack[top] = item;
    }
    
    // Takes the top item off the stack
    public GroceryItem pop() {
        if (isStackEmpty()) {
            return null;
        }
        GroceryItem item = historyStack[top];
        historyStack[top] = null;
        top = top - 1;
        return item;
    }
    
    // Lets us see the top item without removing it
    public GroceryItem peekStack() {
        if (isStackEmpty()) {
            return null;
        }
        return historyStack[top];
    }
    
    // Gets all history items with most recent first
    public ArrayList<GroceryItem> getHistoryItems() {
        ArrayList<GroceryItem> historyItems = new ArrayList<GroceryItem>();
        
        // Go from top to bottom so newest shows first
        for (int i = top; i >= 0; i--) {
            if (historyStack[i] != null) {
                historyItems.add(historyStack[i]);
            }
        }
        
        return historyItems;
    }
    
    // Handles when a user buys something
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
    // It works by taking each item and putting it in the right spot
    public void insertionSortByName() {
        int n = itemList.size();
        
        for (int i = 1; i < n; i++) {
            GroceryItem key = itemList.get(i);
            int j = i - 1;
            
            // Keep moving items right until we find the right spot
            while (j >= 0 && itemList.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                itemList.set(j + 1, itemList.get(j));
                j = j - 1;
            }
            itemList.set(j + 1, key);
        }
    }
    
    // Sorts by price from cheapest to most expensive
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
    
    // Sorts by quantity from lowest to highest stock
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
    
    // Sorts by ID using selection sort
    // It finds the smallest and swaps it to the front, then repeats
    public void selectionSortById() {
        int n = itemList.size();
        
        for (int i = 0; i < n - 1; i++) {
            // Look for the smallest ID in the unsorted part
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (itemList.get(j).getItemId() < itemList.get(minIndex).getItemId()) {
                    minIndex = j;
                }
            }
            
            // Swap it to the current position if needed
            if (minIndex != i) {
                GroceryItem temp = itemList.get(minIndex);
                itemList.set(minIndex, itemList.get(i));
                itemList.set(i, temp);
            }
        }
    }
    
    // Sorts alphabetically using selection sort
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
    
    // Sorts by price using selection sort
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
    
    // Sorts by quantity using selection sort
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
    
    // Linear search goes through each item one by one to find the ID
    public GroceryItem linearSearchById(int targetId) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getItemId() == targetId) {
                return itemList.get(i);
            }
        }
        return null;
    }
    
    // Searches for exact name match, ignoring uppercase/lowercase
    public GroceryItem linearSearchByName(String targetName) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getName().equalsIgnoreCase(targetName)) {
                return itemList.get(i);
            }
        }
        return null;
    }
    
    // This finds all items that contain the search term
    // Useful for the search box where you type partial words
    public ArrayList<GroceryItem> linearSearchByNamePartial(String searchTerm) {
        ArrayList<GroceryItem> results = new ArrayList<GroceryItem>();
        String lowerSearchTerm = searchTerm.toLowerCase();
        
        for (int i = 0; i < itemList.size(); i++) {
            String itemName = itemList.get(i).getName().toLowerCase();
            // Check if item name contains the search term
            if (itemName.indexOf(lowerSearchTerm) >= 0) {
                results.add(itemList.get(i));
            }
        }
        
        return results;
    }
    
    // Binary search is faster but needs sorted data
    // It keeps cutting the list in half until it finds the item
    public GroceryItem binarySearchById(int targetId) {
        // First we need to sort by ID
        selectionSortById();
        
        int low = 0;
        int high = itemList.size() - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = itemList.get(mid).getItemId();
            
            if (midId == targetId) {
                return itemList.get(mid);
            } else if (midId < targetId) {
                // Target is in the right half
                low = mid + 1;
            } else {
                // Target is in the left half
                high = mid - 1;
            }
        }
        
        return null;
    }
    
    // Binary search for finding items by name
    public GroceryItem binarySearchByName(String targetName) {
        // Sort alphabetically first
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
    
    // Calculates the total value of everything in stock
    public double getTotalInventoryValue() {
        double total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            GroceryItem item = itemList.get(i);
            total = total + (item.getQuantity() * item.getPrice());
        }
        return total;
    }
    
    // Adds up how many items we have in total
    public int getTotalStockCount() {
        int total = 0;
        for (int i = 0; i < itemList.size(); i++) {
            total = total + itemList.get(i).getQuantity();
        }
        return total;
    }
    
    // Returns how many different products we have
    public int getTotalItemCount() {
        return itemList.size();
    }
}