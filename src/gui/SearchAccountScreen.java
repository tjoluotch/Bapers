/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controllers.*;
/**
 *
 * @author Tweetie Pie
 */
public class SearchAccountScreen extends javax.swing.JFrame {
    
    /**
     * Creates new form SearchAccountScreen
     */
    BAPACCT bapacct = new BAPACCT();
    public SearchAccountScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        srcAccNoTxtField = new javax.swing.JTextField();
        srcAccNameTxtField = new javax.swing.JTextField();
        srcAccNameButton = new javax.swing.JButton();
        srcAccNoButton = new javax.swing.JButton();
        goBackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        srcPostcodeTxtField = new javax.swing.JTextField();
        srcPostcodeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        srcAccNoTxtField.setText("Search by Account Number");
        srcAccNoTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcAccNoTxtFieldActionPerformed(evt);
            }
        });

        srcAccNameTxtField.setText("Search by Account Holder's Name");
        srcAccNameTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcAccNameTxtFieldActionPerformed(evt);
            }
        });

        srcAccNameButton.setText("Search");
        srcAccNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcAccNameButtonActionPerformed(evt);
            }
        });

        srcAccNoButton.setText("Search");
        srcAccNoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcAccNoButtonActionPerformed(evt);
            }
        });

        goBackButton.setText("Go Back");
        goBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Logo");

        srcPostcodeTxtField.setText("Search by Postcode");
        srcPostcodeTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcPostcodeTxtFieldActionPerformed(evt);
            }
        });

        srcPostcodeButton.setText("Search");
        srcPostcodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcPostcodeButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "first name", "last Name", "acc Type", "discount Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(goBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(srcPostcodeTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(srcPostcodeButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(srcAccNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(srcAccNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(srcAccNoButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(srcAccNameButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(srcAccNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(srcAccNameButton))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(srcAccNoButton)
                            .addComponent(srcAccNoTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(srcPostcodeTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(srcPostcodeButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(goBackButton)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void srcAccNoTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcAccNoTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcAccNoTxtFieldActionPerformed

    private void srcAccNameTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcAccNameTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcAccNameTxtFieldActionPerformed

    private void srcAccNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcAccNameButtonActionPerformed
            bapacct.searchCustomerByName(srcAccNameTxtField);
            
            
    }//GEN-LAST:event_srcAccNameButtonActionPerformed

    private void srcAccNoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcAccNoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcAccNoButtonActionPerformed

    private void goBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goBackButtonActionPerformed

    private void srcPostcodeTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcPostcodeTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcPostcodeTxtFieldActionPerformed

    private void srcPostcodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcPostcodeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcPostcodeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SearchAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAccountScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goBackButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton srcAccNameButton;
    private javax.swing.JTextField srcAccNameTxtField;
    private javax.swing.JButton srcAccNoButton;
    private javax.swing.JTextField srcAccNoTxtField;
    private javax.swing.JButton srcPostcodeButton;
    private javax.swing.JTextField srcPostcodeTxtField;
    // End of variables declaration//GEN-END:variables
}
