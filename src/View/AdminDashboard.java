/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.GroceryItem;
import Controller.GroceryController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer
 */
public class AdminDashboard extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminDashboard.class.getName());

    private GroceryController controller = new GroceryController();
    
    /**
     * Creates new form Dashboard
     */
    public AdminDashboard() {
        initComponents();
        
        // Welcome Message at the top
        jLabel6.setText("Admin Dashboard - Grocery Management System");
        
        // Load data immediately when opening
        loadTableData();
        
        // Add mouse listener to table to fill fields on click
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        
        // Add tab change listener to load data when switching tabs
        jTabbedPane1.addChangeListener(e -> {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            if (selectedIndex == 2) { // Recently Added tab
                loadRecentlyAddedTable();
            } else if (selectedIndex == 3) { // History tab
                loadHistoryTable();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtItemId = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Update2 = new javax.swing.JButton();
        Update1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Grocery Management System");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\Logo  Grocery.png")); // NOI18N

        jButton5.setText("Logout");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category ", "Quantity ", "Price"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        Search.addActionListener(this::SearchActionPerformed);

        jButton2.setText("Search");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton4.setText("Sort By Name");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Total Stock");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total Value");

        jButton6.setText("Sort By ID");
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel9))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dashboard", jPanel3);

        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Item ID ");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(30, 100, 46, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name ");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(30, 140, 36, 16);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Category ");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(30, 180, 53, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Price ");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(30, 250, 31, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Quantity ");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(30, 220, 51, 16);

        txtItemId.addActionListener(this::txtItemIdActionPerformed);
        jPanel4.add(txtItemId);
        txtItemId.setBounds(110, 90, 190, 22);

        txtPrice.addActionListener(this::txtPriceActionPerformed);
        jPanel4.add(txtPrice);
        txtPrice.setBounds(110, 250, 190, 22);

        txtName.addActionListener(this::txtNameActionPerformed);
        jPanel4.add(txtName);
        txtName.setBounds(110, 130, 190, 22);

        txtCategory.addActionListener(this::txtCategoryActionPerformed);
        jPanel4.add(txtCategory);
        txtCategory.setBounds(110, 170, 190, 22);

        txtQuantity.addActionListener(this::txtQuantityActionPerformed);
        jPanel4.add(txtQuantity);
        txtQuantity.setBounds(110, 210, 190, 22);

        jButton1.setText("Add Item");
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel4.add(jButton1);
        jButton1.setBounds(190, 280, 100, 23);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Product details");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(30, 40, 178, 48);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setText("Manipulate Item");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(400, 60, 213, 48);
        jPanel4.add(jTextField6);
        jTextField6.setBounds(390, 130, 210, 22);

        Update.setText("Update");
        Update.addActionListener(this::UpdateActionPerformed);
        jPanel4.add(Update);
        Update.setBounds(420, 170, 149, 29);

        Update2.setText("Delete");
        Update2.addActionListener(this::Update2ActionPerformed);
        jPanel4.add(Update2);
        Update2.setBounds(420, 210, 149, 29);

        Update1.setText("Clear");
        Update1.addActionListener(this::Update1ActionPerformed);
        jPanel4.add(Update1);
        Update1.setBounds(420, 250, 149, 29);

        jTabbedPane1.addTab("Add Item", jPanel4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category ", "Quantity ", "Price"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3)
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Recently Added", jPanel7);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Category ", "Quantity ", "Price"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4)
                    .addContainerGap()))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("History", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtItemIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemIdActionPerformed
        
    }//GEN-LAST:event_txtItemIdActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryActionPerformed
        
    }//GEN-LAST:event_txtCategoryActionPerformed

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
       
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            //  VALIDATION: CHECK EMPTY FIELDS 
            if (txtItemId.getText().trim().isEmpty()
                || txtName.getText().trim().isEmpty()
                || txtCategory.getText().trim().isEmpty()
                || txtQuantity.getText().trim().isEmpty()
                || txtPrice.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop execution
            }

            //  DATA EXTRACTION & PARSING 
            int id = Integer.parseInt(txtItemId.getText().trim());
            String name = txtName.getText().trim();
            String category = txtCategory.getText().trim();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            double price = Double.parseDouble(txtPrice.getText().trim());

            //  MODEL CREATION 
            // (The GroceryItem class handles negative number validation internally)
            GroceryItem newItem = new GroceryItem(id, name, category, quantity, price);

            //  CONTROLLER CALL 
            controller.addItem(newItem);
            
            // Refresh table with new data
            loadTableData();

            // --- SUCCESS FEEDBACK ---
            JOptionPane.showMessageDialog(this, "Item Added Successfully!");

            // Clear the form for the next entry
            clearFields();

        } catch (NumberFormatException e) {
            // Requirement: Handle invalid number formats (e.g., "abc" in Price)
            JOptionPane.showMessageDialog(this, "ID, Quantity, and Price must be valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            // Requirement: Catch duplicate IDs/Names or negative numbers from Model/Controller
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
    }//GEN-LAST:event_SearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Search functionality - uses Binary Search for ID, Linear Search for Name
        String searchTerm = Search.getText().trim();
        
        if (searchTerm.isEmpty()) {
            loadTableData(); // Reset to show all
            return;
        }
        
        // Try as ID first (Binary Search)
        try {
            int searchId = Integer.parseInt(searchTerm);
            GroceryItem found = controller.binarySearchById(searchId);
            
            if (found != null) {
                displaySingleItem(found);
                JOptionPane.showMessageDialog(this, "Found using Binary Search!");
            } else {
                JOptionPane.showMessageDialog(this, "Item not found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException e) {
            // Not a number, use Linear Search for Name
            java.util.ArrayList<GroceryItem> results = controller.linearSearchByNamePartial(searchTerm);
            
            if (!results.isEmpty()) {
                displaySearchResults(results);
                JOptionPane.showMessageDialog(this, "Found " + results.size() + " result(s) using Linear Search!");
            } else {
                JOptionPane.showMessageDialog(this, "No items found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Sort by Name using Insertion Sort
        controller.insertionSortByName();
        loadTableData();
        JOptionPane.showMessageDialog(this, "Sorted by Name using Insertion Sort!");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        try {
            int id = Integer.parseInt(txtItemId.getText().trim());
            String name = txtName.getText().trim();
            String category = txtCategory.getText().trim();
            int quantity = Integer.parseInt(txtQuantity.getText().trim());
            double price = Double.parseDouble(txtPrice.getText().trim());

            GroceryItem updatedItem = new GroceryItem(id, name, category, quantity, price);
            controller.updateItem(updatedItem);
            
            loadTableData(); // Refresh table
           JOptionPane.showMessageDialog(this, "Item Updated Successfully!");
            clearFields();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please check your inputs.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void Update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update2ActionPerformed
        try {
            int selectedRow = jTable2.getSelectedRow();
            int id;

            // Option 1: Delete by selecting a row
            if (selectedRow != -1) {
                id = (int) jTable2.getValueAt(selectedRow, 0); 
            } 
            // Option 2: Delete by typing ID manually
            else if (!txtItemId.getText().isEmpty()) {
                id = Integer.parseInt(txtItemId.getText().trim());
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row or enter an ID to delete.", "Warning",JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete ID: " + id + "?", "Confirm Delete",JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.deleteItem(id);
                loadTableData();
                JOptionPane.showMessageDialog(this, "Item Deleted.");
                clearFields();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Update2ActionPerformed

    private void Update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update1ActionPerformed
        clearFields();
    }//GEN-LAST:event_Update1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    loadTableData();    // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Sort by ID using Selection Sort
        controller.selectionSortById();
        loadTableData();
        JOptionPane.showMessageDialog(this, "Sorted by ID using Selection Sort!");
    }//GEN-LAST:event_jButton6ActionPerformed
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Helper to refresh the JTable data from the controller.
     */
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Clear old data
        
        for (GroceryItem item : controller.getAllItems()) {
            Object[] row = {
                item.getItemId(),
                item.getName(),
                item.getCategory(),
                item.getQuantity(),
                item.getPrice()
            };
            model.addRow(row);
        }
    }

    /**
     * Helper to clear text fields after an action.
     */
    private void clearFields() {
        txtItemId.setText("");
        txtName.setText("");
        txtCategory.setText("");
        txtQuantity.setText("");
        txtPrice.setText("");
    }

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            
            txtItemId.setText(model.getValueAt(selectedRow, 0).toString());
            txtName.setText(model.getValueAt(selectedRow, 1).toString());
            txtCategory.setText(model.getValueAt(selectedRow, 2).toString());
            txtQuantity.setText(model.getValueAt(selectedRow, 3).toString());
            txtPrice.setText(model.getValueAt(selectedRow, 4).toString());
        }
    }
    
    // Helper to display a single item in the table (for search results)
    private void displaySingleItem(GroceryItem item) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        Object[] row = {
            item.getItemId(),
            item.getName(),
            item.getCategory(),
            item.getQuantity(),
            item.getPrice()
        };
        model.addRow(row);
    }
    
    // Helper to display multiple search results
    private void displaySearchResults(java.util.ArrayList<GroceryItem> results) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        for (GroceryItem item : results) {
            Object[] row = {
                item.getItemId(),
                item.getName(),
                item.getCategory(),
                item.getQuantity(),
                item.getPrice()
            };
            model.addRow(row);
        }
    }
    
    // Load Recently Added items from Queue into jTable3
    private void loadRecentlyAddedTable() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        
        java.util.ArrayList<GroceryItem> recentItems = controller.getRecentlyAddedItems();
        for (GroceryItem item : recentItems) {
            Object[] row = {
                item.getItemId(),
                item.getName(),
                item.getCategory(),
                item.getQuantity(),
                item.getPrice()
            };
            model.addRow(row);
        }
    }
    
    // Load History items from Stack into jTable4
    private void loadHistoryTable() {
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        
        java.util.ArrayList<GroceryItem> historyItems = controller.getHistoryItems();
        for (GroceryItem item : historyItems) {
            Object[] row = {
                item.getItemId(),
                item.getName(),
                item.getCategory(),
                item.getQuantity(),
                item.getPrice()
            };
            model.addRow(row);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminDashboard().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Search;
    private javax.swing.JButton Update;
    private javax.swing.JButton Update1;
    private javax.swing.JButton Update2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtItemId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
