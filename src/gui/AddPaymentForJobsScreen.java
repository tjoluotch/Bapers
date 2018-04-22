/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controllers.BAPPAYM;
import TableModels.JobsTableModel;
import data.DataManagerImpl;
import domain.DiscountPlan;
import domain.JobLine;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class AddPaymentForJobsScreen extends javax.swing.JFrame {

    /**
     * Creates new form AddPaymentForJobScreen
     */
    
    DataManagerImpl dm = new DataManagerImpl();
    BAPPAYM paym = new BAPPAYM(dm);
    
    List<JobLine> jobList;
    List<JobLine> selectedJobs;
    List<JobLine> jobsToRemove;
    List<DiscountPlan> discounts;
    JobsTableModel jobsTableModel;
    JobsTableModel basketModel;
    float defaultPrice;
    float actualPrice;
    
    
    public AddPaymentForJobsScreen() {
        initComponents();
    }
    
    AddPaymentForJobsScreen(List<JobLine> jobList, List<DiscountPlan> discounts){
        this.actualPrice = 0;
        this.defaultPrice = 0;
        this.jobList = jobList;
        this.discounts = discounts;
        this.basketModel = new JobsTableModel();
        this.jobsTableModel = new JobsTableModel(jobList);
        this.selectedJobs = new ArrayList<>();
        this.jobsToRemove = new ArrayList<>();
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobsTable = new javax.swing.JTable();
        paymentTypeComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        expiryDateField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        last4Field = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        basketTable = new javax.swing.JTable();
        basketLabel = new javax.swing.JLabel();
        defaultPriceAnnotation = new javax.swing.JLabel();
        defaultPriceLabel = new javax.swing.JLabel();
        actualPriceAnnotation = new javax.swing.JLabel();
        actualPriceLabel = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jobsTable.setModel(jobsTableModel
        );
        jobsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobsTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jobsTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jobsTable);

        paymentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cash" }));
        paymentTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Payment Type:");

        jLabel2.setText("Expiry Date (MM/YY):");

        jLabel3.setText("Last 4 Digits:");

        last4Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last4FieldActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");

        basketTable.setModel(basketModel
        );
        basketTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basketTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(basketTable);

        basketLabel.setText("Basket:");

        defaultPriceAnnotation.setText("Default Price:");

        defaultPriceLabel.setText("0");

        actualPriceAnnotation.setText("Actual Price:");

        actualPriceLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(expiryDateField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(last4Field, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(defaultPriceAnnotation)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(actualPriceAnnotation)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(defaultPriceLabel)
                            .addComponent(actualPriceLabel))
                        .addGap(6, 6, 6))
                    .addComponent(paymentTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(166, 166, 166)))
                            .addComponent(jLabel2)))
                    .addComponent(basketLabel)
                    .addComponent(jLabel1))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(basketLabel)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(defaultPriceAnnotation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(actualPriceAnnotation)
                                    .addComponent(actualPriceLabel)))
                            .addComponent(defaultPriceLabel))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(paymentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(expiryDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(last4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(backButton))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobsTableMouseClicked
        //find the jobID for the job selected in the table
        int selectedRowIndex = jobsTable.getSelectedRow();
        String jobId = jobsTable.getValueAt(selectedRowIndex, 0).toString();
        int jobID = Integer.parseInt(jobId);
        for(JobLine job : jobList){
            if(job.getJoblineID() == jobID){
                //prevent the user from adding a job that is already in the basket
                if(selectedJobs.contains(job)){} else {
                //add the job with the same jobID that the user selected
                selectedJobs.add(job);
                }
            }
        }
        //calculate default price and actual price (with discounts)
        defaultPrice = paym.getNormalPrice(selectedJobs);
        
      if (discounts.size()> 1){
           actualPrice = paym.variableCalculate(selectedJobs, discounts); 
        }
        
        else {
            if(discounts.get(0).getFlexibleRate() != null){
                actualPrice = paym.fixedPrice(defaultPrice, discounts); 
                
            }
            
            else{
                
                 actualPrice = paym.flexibleCalculate(selectedJobs, discounts);
                
                
            }
        }
        
        
        
        basketModel = new JobsTableModel(selectedJobs);
        basketModel.fireTableDataChanged();
        basketTable.setModel(basketModel);
        defaultPriceLabel.setText(String.valueOf(defaultPrice));
        actualPriceLabel.setText(String.valueOf(actualPrice));
    }//GEN-LAST:event_jobsTableMouseClicked

    private void jobsTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobsTableMouseReleased

    }//GEN-LAST:event_jobsTableMouseReleased

    private void paymentTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentTypeComboBoxActionPerformed

    private void last4FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last4FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_last4FieldActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
//FOR CARD PAYMENTS
        if((paymentTypeComboBox.getSelectedItem().toString()).equals("Card")){
            if(last4Field.getText().equals("") || expiryDateField.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please enter all required information.","Invalid Data Error",JOptionPane.ERROR_MESSAGE);
            } else {
            String day = "01";
            String month = expiryDateField.getText().substring(0,2);
            String year = "20" + expiryDateField.getText().substring(3,5);
            String expiryDate = year + "-" + month + "-" + day;    
            boolean dates = false;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
            sdf.setLenient(false);
            try{
                sdf.parse(expiryDateField.getText().trim());
                dates = true;
            } catch (ParseException pe) { dates = false; }

            if(dates == false){
                JOptionPane.showMessageDialog(this,"Please enter a valid date","Invalid Date Error",JOptionPane.ERROR_MESSAGE);
            } else if ((paymentTypeComboBox.getSelectedItem().toString()).equals("Card")){
                paym.createPayment(selectedJobs, last4Field.getText(), Date.valueOf(expiryDate), actualPrice);
                JOptionPane.showMessageDialog(this,"Card Payment for job(s) added","",JOptionPane.INFORMATION_MESSAGE);
            }
            }
        }
        //FOR CASH PAYMENTS
        else if ((paymentTypeComboBox.getSelectedItem().toString()).equals("Cash")){
            paym.createPayment(selectedJobs, actualPrice);
            JOptionPane.showMessageDialog(this,"Cash Payment for job(s) added","",JOptionPane.INFORMATION_MESSAGE);
        }
        
            
    }//GEN-LAST:event_submitButtonActionPerformed

    private void basketTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basketTableMouseClicked
        int selectedRowIndex = basketTable.getSelectedRow();
        String jobId = basketTable.getValueAt(selectedRowIndex, 0).toString();
        int jobID = Integer.parseInt(jobId);
        List<JobLine> removeList = new LinkedList();
        
        for(JobLine job : selectedJobs){
            if(job.getJoblineID() != jobID){
                removeList.add(job);
            }
        }
        
        selectedJobs = removeList;
        basketModel = new JobsTableModel(selectedJobs);
        
         if (discounts.size()> 1){
           actualPrice = paym.variableCalculate(selectedJobs, discounts); 
        }
        
        else {
            if(discounts.get(0).getFlexibleRate() != null){
                actualPrice = paym.fixedPrice(defaultPrice, discounts); 
                
            }
            
            else{
                
                 actualPrice = paym.flexibleCalculate(selectedJobs, discounts);
                
                
            }
        }
        
        defaultPrice = paym.getNormalPrice(selectedJobs);
        
        defaultPriceLabel.setText(String.valueOf(defaultPrice));
        actualPriceLabel.setText(String.valueOf(actualPrice));
       
        basketModel.fireTableDataChanged();
        basketTable.setModel(basketModel);
    }//GEN-LAST:event_basketTableMouseClicked

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
            java.util.logging.Logger.getLogger(AddPaymentForJobsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPaymentForJobsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPaymentForJobsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPaymentForJobsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPaymentForJobsScreen().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualPriceAnnotation;
    private javax.swing.JLabel actualPriceLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel basketLabel;
    private javax.swing.JTable basketTable;
    private javax.swing.JLabel defaultPriceAnnotation;
    private javax.swing.JLabel defaultPriceLabel;
    private javax.swing.JTextField expiryDateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable jobsTable;
    private javax.swing.JTextField last4Field;
    private javax.swing.JComboBox<String> paymentTypeComboBox;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
