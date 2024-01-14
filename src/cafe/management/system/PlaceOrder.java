/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import dataaccessobject.ProductDataAccessObject;
import model.Product;
import java.util.Iterator;
import dataaccessobject.BillDataAccessObject;
import dataaccessobject.CategoryDataAccessObject;
import model.Category;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Bill;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import com.itextpdf.text.Paragraph; 
import common.OpenPdf;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.File;


/**
 *
 * @author chloeglynn
 */

//main methods 
public class PlaceOrder extends javax.swing.JFrame {
    public int billId = 1;
    public int grandTotal = 0;
    public int productPrice = 0;
    public int productTotal = 0;
    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "[0-9]*$";
    public String userEmail;

    /**
     * Creates new form PlaceOrder
     */
    public PlaceOrder() {
        initComponents();
    }
    //make buttons ineditable as info will populate based on selection
    public PlaceOrder(String email) {
        initComponents();
        orderProductName.setEditable(false);
        orderProductPrice.setEditable(false);
        orderTotal.setEditable(false);
        btnAddToCart.setEnabled(false);
        btnGenerateBill.setEnabled(false);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) jSpinner1.getEditor()).getTextField();
        tf.setEditable(false);
        userEmail = email;
    }
    //fetch categories available in database
    public void productNameByCategory(String category){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDataAccessObject.getAllRecordsByCategory(category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product productObject = itr.next();
            dtm.addRow(new Object[]{productObject.getName()});
        }
    }
    
    //fetch product names available in database
    public void filterProductByName(String name, String category){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        ArrayList<Product> list = ProductDataAccessObject.filterProductByName(name,category);
        Iterator<Product> itr = list.iterator();
        while(itr.hasNext()){
            Product productObject = itr.next();
            dtm.addRow(new Object[]{productObject.getName()});
        }
    }
    
    //clear fields
    public void clearProductFields(){
        orderProductName.setText("");
        orderProductPrice.setText("");
        jSpinner1.setValue(1);
        orderTotal.setText("");
        btnAddToCart.setEnabled(false);
    }
    
    //validate fields
    public void validateFields(){
        String customerName = orderName.getText();
        String customerMobileNumber = orderMobileNumber.getText();
        String customerEmail = orderEmail.getText();
        if(!customerName.equals("") && customerMobileNumber.matches(mobileNumberPattern) && customerMobileNumber.length() == 10 && customerEmail.matches(emailPattern) && grandTotal > 0){
            btnGenerateBill.setEnabled(true);
        }
        else{
            btnGenerateBill.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orderName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        orderMobileNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        orderEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        orderSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        orderProductName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        orderProductPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        orderTotal = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnGenerateBill = new javax.swing.JButton();
        grandTotalLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jLabel1.setText("Place Order");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 32, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1137, 32, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Bill ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 95, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer Details");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 133, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 171, -1, -1));

        orderName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderNameKeyReleased(evt);
            }
        });
        getContentPane().add(orderName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 206, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mobile Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 247, -1, -1));

        orderMobileNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderMobileNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderMobileNumberKeyReleased(evt);
            }
        });
        getContentPane().add(orderMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 282, 170, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 323, -1, -1));

        orderEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderEmailKeyReleased(evt);
            }
        });
        getContentPane().add(orderEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 358, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Category");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        orderSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        orderSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                orderSearchKeyReleased(evt);
            }
        });
        getContentPane().add(orderSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Name");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, -1, -1));

        orderProductName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(orderProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Price");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, -1, -1));

        orderProductPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(orderProductPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 130, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Quantity");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 170, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Total");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, -1, -1));
        getContentPane().add(orderTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 170, -1));

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, -1));

        btnAddToCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        btnAddToCart.setText("Add to Cart");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 260, -1, -1));

        jTable2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Price", "Quantity", "Total"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 504, 380));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Grand Total = EUR ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 720, -1, -1));

        btnGenerateBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 710, -1, -1));

        grandTotalLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        grandTotalLabel.setText("000");
        getContentPane().add(grandTotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 720, -1, -1));

        jLabel14.setText("--");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 30, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // close and display home page
        setVisible(false);
        new Home(userEmail).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
        billId = Integer.parseInt(BillDataAccessObject.getId());
        jLabel14.setText(BillDataAccessObject.getId());
        ArrayList<Category> list = CategoryDataAccessObject.getAllRecords();
        Iterator<Category> itr = list.iterator();
        while(itr.hasNext()){
            Category categoryObject = itr.next();
            jComboBox1.addItem(categoryObject.getName());
        }
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
    }//GEN-LAST:event_formComponentShown

    private void orderSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderSearchKeyReleased
        // search products by name
        String name = orderSearch.getText();
        String category = (String) jComboBox1.getSelectedItem();
        filterProductByName(name,category);
    }//GEN-LAST:event_orderSearchKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // display products available in database in product table
        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String productName = model.getValueAt(index, 0).toString();
        Product product = ProductDataAccessObject.getProductByName(productName);
        orderProductName.setText(product.getName());
        orderProductPrice.setText(product.getPrice());
        jSpinner1.setValue(1);
        orderTotal.setText(product.getPrice());
        productPrice = Integer.parseInt(product.getPrice());
        productTotal = Integer.parseInt(product.getPrice());
        btnAddToCart.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // allow user to select quantity of item 
        int quantity  = (Integer) jSpinner1.getValue();
        if(quantity<=1){
            jSpinner1.setValue(1);
            quantity = 1;
        }
        
        productTotal = productPrice * quantity;
        orderTotal.setText(String.valueOf(productTotal));
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // display categories in drop down list
        String category = (String) jComboBox1.getSelectedItem();
        productNameByCategory(category);
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // add item(s) selected to cart
        String name = orderProductName.getText();
        String price = orderProductPrice.getText();
        String quantity = String.valueOf(jSpinner1.getValue());
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name,price,quantity,productTotal});
        grandTotal = grandTotal + productTotal;
        grandTotalLabel.setText(String.valueOf(grandTotal));
        
        clearProductFields();
        validateFields();
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // clear fields
        clearProductFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void orderNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderNameKeyReleased
        // validate field
        validateFields();
    }//GEN-LAST:event_orderNameKeyReleased

    private void orderMobileNumberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderMobileNumberKeyReleased
        // validate field
        validateFields();
    }//GEN-LAST:event_orderMobileNumberKeyReleased

    private void orderEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderEmailKeyReleased
        // validate field
        validateFields();
    }//GEN-LAST:event_orderEmailKeyReleased

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        // generate bill based on customer information entered and items added to cart
        String customerName = orderName.getText();
        String customerMobileNumber = orderMobileNumber.getText();
        String customerEmail = orderEmail.getText();
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String todayDate = dFormat.format(date);
        String total = String.valueOf(grandTotal);
        String createdBy = userEmail;
        Bill bill = new Bill();
        bill.setId(billId);
        bill.setName(customerName);
        bill.setMobileNumber(customerMobileNumber);
        bill.setEmail(customerEmail);
        bill.setDate(todayDate);
        bill.setTotal(total);
        bill.setCreatedBy(createdBy);
        BillDataAccessObject.save(bill);
        
        
        //Creating document
        String path = "/Users/chloeglynn/Documents/" + File.separator;
        com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(path + "" + billId + ".pdf"));
            doc.open();
            Paragraph cafeName = new Paragraph("                                                         Cafe Management System\n");
            doc.add(cafeName);
            Paragraph starLine = new Paragraph("**********************************************************************************************");
            doc.add(starLine);
            Paragraph paragraph3 = new Paragraph("\tBill ID: "+billId+"\nCustomer Name: "+customerName+"\nTotal Paid: "+grandTotal);
            doc.add(paragraph3);
            doc.add(starLine);
            PdfPTable tb1 = new PdfPTable(4);
            tb1.addCell("Name");
            tb1.addCell("Price");
            tb1.addCell("Quantity");
            tb1.addCell("Total");
            for(int i=0; i <jTable2.getRowCount(); i++){
                String n = jTable2.getValueAt(i, 0).toString();
                String p = jTable2.getValueAt(i, 1).toString();
                String q = jTable2.getValueAt(i, 2).toString();
                String t = jTable2.getValueAt(i, 3).toString();
                tb1.addCell(n);
                tb1.addCell(p);
                tb1.addCell(q);
                tb1.addCell(t);
            }
            doc.add(tb1);
            doc.add(starLine);
            Paragraph thanksMsg = new Paragraph("Thank you, please come again");
            doc.add(thanksMsg);
            
            //Open PDF
            OpenPdf.openById(String.valueOf(billId));
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        doc.close();
        setVisible(false);
        new PlaceOrder(createdBy).setVisible(true);
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // when row clicked, ask user if they want to remove item and remove it when user clicks yes or leave it if clicks no
        int index = jTable2.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null,"Do you want to remove this product?", "Message", JOptionPane.YES_NO_OPTION);
        if(a==0){
            TableModel model = jTable2.getModel();
            String total = model.getValueAt(index, 3).toString();
            grandTotal = grandTotal - Integer.parseInt(total);
            grandTotalLabel.setText(String.valueOf(grandTotal));
            ((DefaultTableModel) jTable2.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_jTable2MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JLabel grandTotalLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField orderEmail;
    private javax.swing.JTextField orderMobileNumber;
    private javax.swing.JTextField orderName;
    private javax.swing.JTextField orderProductName;
    private javax.swing.JTextField orderProductPrice;
    private javax.swing.JTextField orderSearch;
    private javax.swing.JTextField orderTotal;
    // End of variables declaration//GEN-END:variables
}
