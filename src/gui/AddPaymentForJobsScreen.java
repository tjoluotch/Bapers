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
import domain.TaskLine;
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
    List<JobLine> selectedJobs = new ArrayList<>();
    List<JobLine> jobsToRemove = new ArrayList<>();
    List<DiscountPlan> discounts;
    JobsTableModel jobsTableModel;
    JobsTableModel basketModel = new JobsTableModel();
    float normalPrice = 0;
    float actualPrice = 0;
    
    
    public AddPaymentForJobsScreen() {
        initComponents();
    }
    
    AddPaymentForJobsScreen(List<JobLine> jobList, List<DiscountPlan> discounts){
        this.jobList = jobList;
        this.discounts = discounts;
        jobsTableModel = new JobsTableModel(jobList);
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
        cancelButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        basketTable = new javax.swing.JTable();
        basketLabel = new javax.swing.JLabel();
        NormalPriceLabel = new javax.swing.JLabel();
        NormalPrice = new javax.swing.JLabel();
        ActualPriceLabel = new javax.swing.JLabel();
        ActualPrice = new javax.swing.JLabel();

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

        cancelButton.setText("Cancel");

        basketTable.setModel(basketModel
        );
        basketTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basketTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(basketTable);

        basketLabel.setText("Basket:");

        NormalPriceLabel.setText("Normal Price:");

        NormalPrice.setText("0");

        ActualPriceLabel.setText("Actual Price:");

        ActualPrice.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(expiryDateField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(last4Field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(NormalPriceLabel)
                                        .addGap(37, 37, 37))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ActualPriceLabel)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NormalPrice)
                                    .addComponent(ActualPrice))
                                .addGap(6, 6, 6))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(paymentTypeComboBox, 0, 238, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(166, 166, 166)))
                                .addComponent(jLabel2)))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(basketLabel)
                                .addComponent(jLabel1)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(basketLabel)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NormalPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ActualPriceLabel)
                                    .addComponent(ActualPrice)))
                            .addComponent(NormalPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(submitButton)
                            .addComponent(cancelButton))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobsTableMouseClicked
         int selectedRowIndex = jobsTable.getSelectedRow();
        String jobId = jobsTable.getValueAt(selectedRowIndex, 0).toString();
        int jobID = Integer.parseInt(jobId);
        for(JobLine job : jobList){
            if(job.getJoblineID() == jobID){
                selectedJobs.add(job);
            }
        }
        normalPrice = paym.getNormalPrice(selectedJobs);
        actualPrice = paym.getPrice(selectedJobs, discounts);
        basketModel = new JobsTableModel(selectedJobs);
        basketModel.fireTableDataChanged();
        basketTable.setModel(basketModel);
        NormalPrice.setText(String.valueOf(normalPrice));
        ActualPrice.setText(String.valueOf(actualPrice));
        System.out.println(selectedJobs.size());
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
            String day = "01";
            String month = expiryDateField.getText().substring(0,2);
            String year = "20" + expiryDateField.getText().substring(3,5);
            String expiryDate = year + "-" + month + "-" + day;    
            System.out.println(expiryDate);
            boolean dates = false;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
            sdf.setLenient(false);
            try{
                sdf.parse(expiryDateField.getText().trim());
                dates = true;
            } catch (ParseException pe) { dates = false; }

            if(dates == false){
                JOptionPane.showMessageDialog(this,"Please enter a valid date","Invalid Date Error",JOptionPane.ERROR_MESSAGE);
            } else {
                //ERROR HERE:
                paym.createPayment(selectedJobs, last4Field.getText(), Date.valueOf(expiryDate));
                // IT DOESN'T LIKE THE DATE
                JOptionPane.showMessageDialog(this,"Card Payment for job(s) added","",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        //FOR CASH PAYMENTS
        else if ((paymentTypeComboBox.getSelectedItem().toString()).equals("Cash")){
            paym.createPayment(selectedJobs);
            JOptionPane.showMessageDialog(this,"Cash Payment for job(s) added","",JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void basketTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basketTableMouseClicked
         int selectedRowIndex = basketTable.getSelectedRow();
        String jobId = basketTable.getValueAt(selectedRowIndex, 0).toString();
        int jobID = Integer.parseInt(jobId);
        List<JobLine> removeList = new LinkedList();
        actualPrice = 0;
        for(JobLine job : selectedJobs){
            
            if(job.getJoblineID() != jobID){
                removeList.add(job);
                actualPrice += job.getJobCode().getPrice();
            }
            
        }
        
        selectedJobs = removeList;
        basketModel = new JobsTableModel(selectedJobs);
        
        NormalPrice.setText(String.valueOf(actualPrice));
       
        basketModel.fireTableDataChanged();
        basketTable.setModel(basketModel);
        System.out.println(selectedJobs.size());
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
    private javax.swing.JLabel ActualPrice;
    private javax.swing.JLabel ActualPriceLabel;
    private javax.swing.JLabel NormalPrice;
    private javax.swing.JLabel NormalPriceLabel;
    private javax.swing.JLabel basketLabel;
    private javax.swing.JTable basketTable;
    private javax.swing.JButton cancelButton;
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
