/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * User model for authentication
 * Stores username, password and role (admin or user)
 * 
 * @author Saksham Kandel
 */
public class User {
    
    private String username;
    private String password;
    private String role; // "admin" or "user"
    
    // Constructor
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    // Getters
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    // Setters
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    // Check if this user is an admin
    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }
    
    // Check if this user is a regular user
    public boolean isUser() {
        return "user".equalsIgnoreCase(role);
    }
    
    public String toString() {
        return "User: " + username + " | Role: " + role;
    }
}
