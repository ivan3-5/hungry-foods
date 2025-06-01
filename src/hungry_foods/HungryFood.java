/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hungry_foods;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class HungryFood extends javax.swing.JFrame {
    int totalNoTax;
    double taxAdded;
    double totalWithTax;
    int x;
    boolean addtocartPressed = false;
    
    double taxCash = 0;
    double taxGCash = 0.05;
  
    public HungryFood() {
        initComponents(); 
        setScalingImages();
    }
    
    private void loadAndScaleImage(JLabel label, String imagePath) {
        try {
            int labelWidth = label.getWidth();
            int labelHeight = label.getHeight();

            ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
            java.awt.Image originalImage = originalIcon.getImage();

            double imgRatio = (double)originalIcon.getIconHeight() / originalIcon.getIconWidth();
            double labelRatio = (double)labelHeight / labelWidth;

            int newWidth, newHeight;

            if (labelRatio > imgRatio) {
                newWidth = labelWidth;
                newHeight = (int)(labelWidth * imgRatio);
            } else {
                newHeight = labelHeight;
                newWidth = (int)(labelHeight / imgRatio);
            }

            java.awt.Image scaledImage = originalImage.getScaledInstance(
                newWidth, 
                newHeight, 
                java.awt.Image.SCALE_SMOOTH
            );

            label.setIcon(new ImageIcon(scaledImage));
        } catch (Exception e) {
            System.err.println("Error loading image for label: " + e.getMessage());
            label.setText("No Image");
        }
    }
    
    public void setScalingImages() {
        SwingUtilities.invokeLater(() -> {
            loadAndScaleImage(image1,  "/image/CheeseBurger.png");          
            loadAndScaleImage(image2,  "/image/Coca-Cola.jpg");           
            loadAndScaleImage(image3,  "/image/Fries.png");      
            loadAndScaleImage(image4,  "/image/Halo-Halo.png");        
            loadAndScaleImage(image5,  "/image/IceCream.jpg");            
            loadAndScaleImage(image6,  "/image/IceTea.jpg");     
            loadAndScaleImage(image7,  "/image/Pizza.jpg");      
            loadAndScaleImage(image8,  "/image/Sandwich.jpg");          
            loadAndScaleImage(image9,  "/image/Spaghetti.jpg"); 
            loadAndScaleImage(image10, "/image/Sundae.jpg");
            loadAndScaleImage(logo,    "/image/Velora.png");      
        });
    }
    
    public String selectedMethod() {
        if (paymentMethodCash.isSelected()) {
            return "Cash";
        }
        if (paymentMethodGCash.isSelected()) {
            return "GCash";
        }
        return null;
    }
    
    public void printReceipt(String name, int price, int quantity) {
        this.x++;
        if (this.x == 1) {
            textAreaReceipt.setText(
                "******************* Hungry Foods *******************\n" +
                "****************************************************\n" +
                String.format("%-3s %-16s %6s %4s %10s\n", "#", "Name", "Price", "Qty", "Amount")
            );
        }

        String prevReceipt = textAreaReceipt.getText();
        int totalAmount = price * quantity;
        this.totalNoTax += totalAmount;

        String formattedLine = String.format("%-3s %-16s %6s %4s %10s\n",
                                             this.x, name, price, quantity, totalAmount);

        textAreaReceipt.setText(prevReceipt + formattedLine);
    }
    
    public void totalReceipt() {
        if (!this.addtocartPressed) {
            int totalPress = JOptionPane.showConfirmDialog(
                null, 
                "Do you really want to get the grand total payment?", 
                "Select", 
                JOptionPane.YES_NO_OPTION
            );
            if (totalPress == 0) {
                String prevReceipt = textAreaReceipt.getText();
                String formattedLine = 
                      "****************************************************\n" +
                      String.format("%-28s %22s\n", "Selected Payment Method:", selectedMethod()) +
                      String.format("%-28s ₱%21d\n", "Sub Total:", this.totalNoTax) +
                      String.format("%-28s ₱%21.2f\n", "Tax Added:", this.taxAdded) +
                      String.format("%-28s ₱%21.2f\n", "Grand Total:", this.totalWithTax);

                textAreaReceipt.setText(prevReceipt + formattedLine);
                grandTotal.setText(String.format("%.2f", this.totalWithTax));
                this.addtocartPressed = true;
            }
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "Total button already pressed.", 
                "Invalid", 
                JOptionPane.WARNING_MESSAGE
            );
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentmethod = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaReceipt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        paymentMethodCash = new javax.swing.JRadioButton();
        paymentMethodGCash = new javax.swing.JRadioButton();
        labelTotal = new javax.swing.JLabel();
        labelTax = new javax.swing.JLabel();
        grandTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spinner1 = new javax.swing.JSpinner();
        price1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        name2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        spinner2 = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        price2 = new javax.swing.JLabel();
        image2 = new javax.swing.JLabel();
        panel19 = new javax.swing.JPanel();
        name3 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        spinner3 = new javax.swing.JSpinner();
        price3 = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        name4 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        price4 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        spinner4 = new javax.swing.JSpinner();
        image4 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        name5 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        price5 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        spinner5 = new javax.swing.JSpinner();
        image5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        name6 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        price6 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        spinner6 = new javax.swing.JSpinner();
        image6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        name7 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        price7 = new javax.swing.JLabel();
        spinner7 = new javax.swing.JSpinner();
        jLabel45 = new javax.swing.JLabel();
        image7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        name8 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        price8 = new javax.swing.JLabel();
        spinner8 = new javax.swing.JSpinner();
        jLabel48 = new javax.swing.JLabel();
        image8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        name9 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        price9 = new javax.swing.JLabel();
        spinner9 = new javax.swing.JSpinner();
        jLabel51 = new javax.swing.JLabel();
        image9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        name10 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        price10 = new javax.swing.JLabel();
        spinner10 = new javax.swing.JSpinner();
        jLabel54 = new javax.swing.JLabel();
        image10 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        add1 = new javax.swing.JButton();
        add2 = new javax.swing.JButton();
        add3 = new javax.swing.JButton();
        add4 = new javax.swing.JButton();
        add5 = new javax.swing.JButton();
        add6 = new javax.swing.JButton();
        add7 = new javax.swing.JButton();
        add8 = new javax.swing.JButton();
        add9 = new javax.swing.JButton();
        add10 = new javax.swing.JButton();
        receipt = new javax.swing.JButton();
        addtocart = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(50, 38, 25));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(76, 60, 45));

        jPanel4.setBackground(new java.awt.Color(221, 201, 140));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 38, 25));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Milk Tea Menu");

        jPanel14.setBackground(new java.awt.Color(50, 38, 25));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        textAreaReceipt.setColumns(20);
        textAreaReceipt.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        textAreaReceipt.setRows(5);
        textAreaReceipt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textAreaReceipt.setEnabled(false);
        jScrollPane1.setViewportView(textAreaReceipt);

        jLabel3.setBackground(new java.awt.Color(221, 201, 140));
        jLabel3.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 201, 140));
        jLabel3.setText("PAYMENT METHOD");

        jLabel16.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 248, 220));
        jLabel16.setText("RECEIPT");

        paymentMethodCash.setBackground(new java.awt.Color(50, 38, 25));
        paymentmethod.add(paymentMethodCash);
        paymentMethodCash.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        paymentMethodCash.setForeground(new java.awt.Color(221, 201, 140));
        paymentMethodCash.setText("Cash");
        paymentMethodCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodCashActionPerformed(evt);
            }
        });

        paymentMethodGCash.setBackground(new java.awt.Color(50, 38, 25));
        paymentmethod.add(paymentMethodGCash);
        paymentMethodGCash.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        paymentMethodGCash.setForeground(new java.awt.Color(221, 201, 140));
        paymentMethodGCash.setText("GCash");
        paymentMethodGCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentMethodGCashActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(221, 201, 140));
        labelTotal.setText("Total:   ₱");

        labelTax.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        labelTax.setForeground(new java.awt.Color(221, 201, 140));
        labelTax.setText("Tax:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(181, 181, 181))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(118, 118, 118))
                    .addComponent(labelTax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(paymentMethodCash, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paymentMethodGCash, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paymentMethodGCash, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(paymentMethodCash, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(labelTax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(grandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 248, 220));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 347));
        jPanel3.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setText("Quantity:");

        jLabel7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel7.setText("Price:");

        price1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price1.setText("₱35");

        name1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setText("Burger");

        image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(image1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(price1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 248, 220));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel15.setPreferredSize(new java.awt.Dimension(205, 341));

        name2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name2.setText("Coke");

        jLabel29.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel29.setText("Price:");

        jLabel30.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel30.setText("Quantity:");

        jLabel31.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        price2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price2.setText("₱25");

        image2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(image2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel31))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(price2)
                                    .addComponent(spinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 14, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(name2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(name2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(price2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(spinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel19.setBackground(new java.awt.Color(255, 248, 220));
        panel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name3.setText("Fries");

        jLabel32.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel32.setText("Price");

        jLabel33.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel33.setText("Quantity");

        price3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price3.setText("₱15");

        image3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout panel19Layout = new javax.swing.GroupLayout(panel19);
        panel19.setLayout(panel19Layout);
        panel19Layout.setHorizontalGroup(
            panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price3))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel19Layout.setVerticalGroup(
            panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(price3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(spinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(255, 248, 220));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name4.setText("Halo-halo");

        jLabel35.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel35.setText("Price");

        price4.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price4.setText("₱60");

        jLabel37.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel37.setText("Quantity");

        image4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinner4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(price4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(spinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel22.setBackground(new java.awt.Color(255, 248, 220));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name5.setText("Ice Cream");

        jLabel38.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel38.setText("Price");

        price5.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price5.setText("₱20");

        jLabel40.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel40.setText("Quantity");

        image5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(image5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price5))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                        .addComponent(name5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price5)
                    .addComponent(jLabel38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(spinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 248, 220));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name6.setText("Ice Tea");

        jLabel41.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel41.setText("Price");

        price6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price6.setText("₱10");

        jLabel43.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel43.setText("Quantity");

        image6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image6, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price6)
                            .addComponent(spinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(price6))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel7.setBackground(new java.awt.Color(255, 248, 220));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name7.setText("Pizza");

        jLabel44.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel44.setText("Price");

        price7.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price7.setText("₱80");

        jLabel45.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel45.setText("Quantity");

        image7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(image7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price7))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(name7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image7, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price7)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(spinner7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 248, 220));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name8.setText("Sandwich");

        jLabel47.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel47.setText("Price");

        price8.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price8.setText("₱25");

        jLabel48.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel48.setText("Quantity");

        image8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price8)
                            .addComponent(spinner8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(name8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image8, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price8)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(spinner8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 248, 220));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name9.setText("Spaghetti");

        jLabel50.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel50.setText("Price");

        price9.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price9.setText("₱50");

        jLabel51.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel51.setText("Quantity");

        image9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinner9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addComponent(image9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image9, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(price9)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(spinner9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel11.setBackground(new java.awt.Color(255, 248, 220));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        name10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        name10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name10.setText("Sundae");

        jLabel53.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel53.setText("Price");

        price10.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        price10.setText("₱40");

        jLabel54.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel54.setText("Quantity");

        image10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel53))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinner10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price10))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(name10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(image10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(image10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price10)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(197, 225, 165));

        add1.setBackground(new java.awt.Color(50, 38, 25));
        add1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 248, 220));
        add1.setText("ADD");
        add1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add2.setBackground(new java.awt.Color(50, 38, 25));
        add2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add2.setForeground(new java.awt.Color(255, 248, 220));
        add2.setText("ADD");
        add2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add2ActionPerformed(evt);
            }
        });

        add3.setBackground(new java.awt.Color(50, 38, 25));
        add3.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add3.setForeground(new java.awt.Color(255, 248, 220));
        add3.setText("ADD");
        add3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add3ActionPerformed(evt);
            }
        });

        add4.setBackground(new java.awt.Color(50, 38, 25));
        add4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add4.setForeground(new java.awt.Color(255, 248, 220));
        add4.setText("ADD");
        add4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add4ActionPerformed(evt);
            }
        });

        add5.setBackground(new java.awt.Color(50, 38, 25));
        add5.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add5.setForeground(new java.awt.Color(255, 248, 220));
        add5.setText("ADD");
        add5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add5ActionPerformed(evt);
            }
        });

        add6.setBackground(new java.awt.Color(50, 38, 25));
        add6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add6.setForeground(new java.awt.Color(245, 240, 230));
        add6.setText("ADD");
        add6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add6ActionPerformed(evt);
            }
        });

        add7.setBackground(new java.awt.Color(50, 38, 25));
        add7.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add7.setForeground(new java.awt.Color(255, 248, 220));
        add7.setText("ADD");
        add7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add7ActionPerformed(evt);
            }
        });

        add8.setBackground(new java.awt.Color(50, 38, 25));
        add8.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add8.setForeground(new java.awt.Color(255, 248, 220));
        add8.setText("ADD");
        add8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add8ActionPerformed(evt);
            }
        });

        add9.setBackground(new java.awt.Color(50, 38, 25));
        add9.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add9.setForeground(new java.awt.Color(255, 248, 220));
        add9.setText("ADD");
        add9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add9ActionPerformed(evt);
            }
        });

        add10.setBackground(new java.awt.Color(50, 38, 25));
        add10.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        add10.setForeground(new java.awt.Color(255, 248, 220));
        add10.setText("ADD");
        add10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add10ActionPerformed(evt);
            }
        });

        receipt.setBackground(new java.awt.Color(92, 74, 57));
        receipt.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        receipt.setForeground(new java.awt.Color(255, 248, 220));
        receipt.setText("RECEIPT");
        receipt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });

        addtocart.setBackground(new java.awt.Color(92, 74, 57));
        addtocart.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        addtocart.setForeground(new java.awt.Color(255, 248, 220));
        addtocart.setText("ADD TO CART");
        addtocart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        addtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtocartActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(92, 74, 57));
        reset.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 248, 220));
        reset.setText("RESET");
        reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(224, 224, 224))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addtocart, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(add6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(add2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(add3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(add4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(add7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(113, 113, 113)
                                        .addComponent(add8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addComponent(add9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(111, 111, 111)
                                        .addComponent(add10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(panel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(panel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(add5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(add3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(add8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(add6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(add9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addtocart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(358, 358, 358)
                                .addComponent(add10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jButton1.setBackground(new java.awt.Color(76, 60, 45));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("❌");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(76, 60, 45));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("➖");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(76, 60, 45));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("⬜");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 248, 220));
        jLabel18.setText("VELORA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.getExtendedState() != java.awt.Frame.MAXIMIZED_BOTH) {
            this.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(java.awt.Frame.NORMAL);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addtocartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtocartActionPerformed
        String receiptCheck = textAreaReceipt.getText();
        if ("".equals(receiptCheck) | " ".equals(receiptCheck)) {
            JOptionPane.showMessageDialog(null, "Receipt is empty.", "Invalid", JOptionPane.WARNING_MESSAGE);
        } else {
            if (paymentMethodCash.isSelected()) {
                this.taxAdded = (this.totalNoTax * this.taxCash);
                this.totalWithTax = (this.taxAdded + this.totalNoTax);
                totalReceipt();
            } else if (paymentMethodGCash.isSelected()) {
                this.taxAdded = (this.totalNoTax * this.taxGCash);
                this.totalWithTax = (this.taxAdded + this.totalNoTax);
                totalReceipt();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a payment method.", "Invalid", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_addtocartActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name1.getText();
            String priceText = price1.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner1.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner1.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add2ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name2.getText();
            String priceText = price2.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner2.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner2.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_add2ActionPerformed

    private void add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add3ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name3.getText();
            String priceText = price3.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner3.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner3.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_add3ActionPerformed

    private void add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add4ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name4.getText();
            String priceText = price4.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner4.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner4.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_add4ActionPerformed

    private void add5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add5ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name5.getText();
            String priceText = price5.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner5.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner5.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_add5ActionPerformed

    private void add7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add7ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name7.getText();
            String priceText = price7.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner7.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner7.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_add7ActionPerformed

    private void add8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add8ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name8.getText();
            String priceText = price8.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner8.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner8.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_add8ActionPerformed

    private void add9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add9ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name9.getText();
            String priceText = price9.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner9.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner9.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }   

    }//GEN-LAST:event_add9ActionPerformed

    private void add10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add10ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name10.getText();
            String priceText = price10.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner10.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner10.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_add10ActionPerformed

    private void add6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add6ActionPerformed
        if (this.addtocartPressed == false) {
            String name = name6.getText();
            String priceText = price6.getText();
            String removeP = priceText.replace("₱", "").trim();
            int price = Integer.parseInt(removeP);
            int quantity = Integer.parseInt(spinner6.getValue().toString());

            System.out.println(name + "-" + price + "-" + quantity);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "No value set or invalid input.", "Invalid", JOptionPane.WARNING_MESSAGE);
            } else {
                printReceipt(name, price, quantity);
                spinner6.setValue(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Total button has been pressed. Need to reset.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_add6ActionPerformed

    private void paymentMethodCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodCashActionPerformed
        
    }//GEN-LAST:event_paymentMethodCashActionPerformed

    private void paymentMethodGCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentMethodGCashActionPerformed
        
    }//GEN-LAST:event_paymentMethodGCashActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        int reset = JOptionPane.showConfirmDialog(null, "Do you really want to reset everything?", "Select", JOptionPane.YES_NO_OPTION);
        if (reset == 0) {
            reset();
        }
    }//GEN-LAST:event_resetActionPerformed

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
        if (this.addtocartPressed == true) {
            int saveReceipt = JOptionPane.showConfirmDialog(null, "Do you want to save the receipt as PDF? (It will overwrite the 'receipt.pdf' file if it exist in 'Downloads' folder.)", "Select", JOptionPane.YES_NO_OPTION);
            if (saveReceipt == 0) {
                String prevReceipt = textAreaReceipt.getText();
                String endingLine = "****************************************************\n" +
                                    "******************** Thank you! ********************\n" +
                                    "****************************************************";
                textAreaReceipt.setText(prevReceipt + endingLine);
                
                System.out.println("Saving PDF...");
                saveReceiptToPDF();
                System.out.println("Saved!");
                JOptionPane.showMessageDialog(null, "Receipt has been saved!", "File Saved", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No total value yet.", "Invalid", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_receiptActionPerformed

    public void saveReceiptToPDF() {
        ExportTextToPDF exportToPDF = new ExportTextToPDF();
        
        String userHome = System.getProperty("user.home");
        Path downloadsPath = Paths.get(userHome, "Downloads");
        Path receiptPath = downloadsPath.resolve("receipt.pdf");
        
        File receiptFile = receiptPath.toFile();
        
        exportToPDF.exportTextAreaToPDF(textAreaReceipt, receiptFile.getAbsolutePath());
    }
    
    public void reset() {
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
        spinner4.setValue(0);
        spinner5.setValue(0);
        spinner6.setValue(0);
        spinner7.setValue(0);
        spinner8.setValue(0);
        spinner9.setValue(0);
        spinner10.setValue(0);
        textAreaReceipt.setText("");
        paymentmethod.clearSelection();
        grandTotal.setText("0");
        this.x = 0;
        this.totalNoTax = 0;
        this.addtocartPressed = false;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JButton add10;
    private javax.swing.JButton add2;
    private javax.swing.JButton add3;
    private javax.swing.JButton add4;
    private javax.swing.JButton add5;
    private javax.swing.JButton add6;
    private javax.swing.JButton add7;
    private javax.swing.JButton add8;
    private javax.swing.JButton add9;
    private javax.swing.JButton addtocart;
    private javax.swing.JTextField grandTotal;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image10;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel image3;
    private javax.swing.JLabel image4;
    private javax.swing.JLabel image5;
    private javax.swing.JLabel image6;
    private javax.swing.JLabel image7;
    private javax.swing.JLabel image8;
    private javax.swing.JLabel image9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTax;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name10;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JLabel name6;
    private javax.swing.JLabel name7;
    private javax.swing.JLabel name8;
    private javax.swing.JLabel name9;
    private javax.swing.JPanel panel19;
    private javax.swing.JRadioButton paymentMethodCash;
    private javax.swing.JRadioButton paymentMethodGCash;
    private javax.swing.ButtonGroup paymentmethod;
    private javax.swing.JLabel price1;
    private javax.swing.JLabel price10;
    private javax.swing.JLabel price2;
    private javax.swing.JLabel price3;
    private javax.swing.JLabel price4;
    private javax.swing.JLabel price5;
    private javax.swing.JLabel price6;
    private javax.swing.JLabel price7;
    private javax.swing.JLabel price8;
    private javax.swing.JLabel price9;
    private javax.swing.JButton receipt;
    private javax.swing.JButton reset;
    private javax.swing.JSpinner spinner1;
    private javax.swing.JSpinner spinner10;
    private javax.swing.JSpinner spinner2;
    private javax.swing.JSpinner spinner3;
    private javax.swing.JSpinner spinner4;
    private javax.swing.JSpinner spinner5;
    private javax.swing.JSpinner spinner6;
    private javax.swing.JSpinner spinner7;
    private javax.swing.JSpinner spinner8;
    private javax.swing.JSpinner spinner9;
    private javax.swing.JTextArea textAreaReceipt;
    // End of variables declaration//GEN-END:variables
}
