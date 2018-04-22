/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controllers.BAPREPT;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tweetie Pie
 */
public class StaffReportsScreen extends javax.swing.JFrame {

    /**
     * Creates new form CustomerReportsScreen
     */
    public StaffReportsScreen() {
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

        bg = new javax.swing.JPanel();
        monthly = new javax.swing.JRadioButton();
        quarterly = new javax.swing.JRadioButton();
        yearly = new javax.swing.JRadioButton();
        custom = new javax.swing.JCheckBox();
        startDate = new javax.swing.JTextField();
        endDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        createButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 204, 102));

        monthly.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        monthly.setText(" Month");
        monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyActionPerformed(evt);
            }
        });

        quarterly.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        quarterly.setText(" Quarter");
        quarterly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterlyActionPerformed(evt);
            }
        });

        yearly.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        yearly.setText("Year");
        yearly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearlyActionPerformed(evt);
            }
        });

        custom.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        custom.setText("Custom Range");
        custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customActionPerformed(evt);
            }
        });

        startDate.setEditable(false);
        startDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                startDateFocusGained(evt);
            }
        });

        endDate.setEditable(false);
        endDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                endDateFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText(" Start Date:");

        createButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 174, 62));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Staff Reports");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/SolSoft.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(114, 114, 114)
                .addComponent(jLabel9)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(37, 37, 37))
        );

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("End Date:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("(DD/MM/YYYY)");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("(DD/MM/YYYY)");

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/backicon.png"))); // NOI18N
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("If selected custom range then enter your selected period:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Please enter your selected period:");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(backButton)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(custom)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(endDate))
                                        .addGap(18, 18, 18)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(monthly)
                                        .addGap(18, 18, 18)
                                        .addComponent(quarterly)
                                        .addGap(17, 17, 17)
                                        .addComponent(yearly))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelButton)
                            .addComponent(createButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthly)
                            .addComponent(quarterly)
                            .addComponent(yearly))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(backButton)
                        .addGap(73, 73, 73)))
                .addComponent(custom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(createButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyActionPerformed
        // TODO add your handling code here:
        if (yearly.isSelected()){
            yearly.setSelected(false);
        }
        if (quarterly.isSelected()){
            quarterly.setSelected(false);
        }
    }//GEN-LAST:event_monthlyActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        
        if(monthly.isSelected()){
            
            LocalDateTime  now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            String currentDate = dtf.format(now);
            String currentMonth = currentDate.substring(3, 5);
            String currentYear = currentDate.substring(6, 10);
            String sDate = "01/" + currentMonth +"/"+ currentYear;
           
            
            BAPREPT rp = new BAPREPT();
            try {
                rp.createMonthlyReport(sDate, currentDate);
            } catch (IOException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PrinterException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            
        }
        
        if(quarterly.isSelected()){
            
            LocalDateTime  now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            String currentDate = dtf.format(now);
            String currentMonth = currentDate.substring(3, 5);
            String currentYear = currentDate.substring(6, 10);
            String sDate = new String();
            String quarter = new String();
            String q = new String();
            
            String [] firstQuarter = {"01", "02", "03"};
            String [] secondQuarter = {"04", "05", "06"};
            String [] thirdQuarter = {"07", "08", "09"};
            String [] fourthQuarter = {"10", "11", "12"};
            
            for(String date: firstQuarter){
                if(date.compareTo(currentMonth)==0){
                     sDate = "01/01/"+ currentYear;
                     quarter = "1st_Quarter";
                     q = "1st Quarter";
                }
            }
            
            for(String date: secondQuarter){
                if(date.compareTo(currentMonth)==0){
                     sDate = "01/04/"+ currentYear;
                     quarter = "2nd_Quarter";
                     q = "2nd Quarter";
                }
            }
            
            for(String date: thirdQuarter){
                if(date.compareTo(currentMonth)==0){
                     sDate = "01/07/"+ currentYear;
                     quarter = "3rd_Quarter";
                     q = "3rd Quarter";
                     
                }
            }
            
            for(String date: fourthQuarter){
                if(date.compareTo(currentMonth)==0){
                     sDate = "01/10/"+ currentYear;
                     quarter = "4th_Quarter";
                     q = "4th Quarter";
                }
            }
            
            BAPREPT rp = new BAPREPT();
            try {
                rp.createQuarterlyReport(sDate, currentDate,quarter,q);
            } catch (IOException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PrinterException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(yearly.isSelected()){
            LocalDateTime  now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            String currentDate = dtf.format(now);
            String currentYear = currentDate.substring(6, 10);
            String sDate = "01/01/" + currentYear;
            
            BAPREPT rp = new BAPREPT();
            try {
                rp.createYearlyReport(sDate, currentDate);
            } catch (IOException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PrinterException ex) {
                Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
        if(custom.isSelected()){
              boolean date1 = false ;
              boolean date2 = false;
            
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                
//                if (!startDate.getText().equals(sdf.format(date1)) | !endDate.getText().equals(sdf.format(date1))) {
//                     date1 = null;
//                     date2 = null;
//                }
                try {
                    sdf.parse(startDate.getText().trim());
                    date1 = true;
                } catch (ParseException pe) {
                     date1 = false;
                 }
                
                try {
                    sdf.parse(endDate.getText().trim());
                    date2 = true;
                } catch (ParseException pe) {
                     date1 = false;
                 }
                            

            
            if (date1 == false | date2 == false) {
                // Invalid date format
                 JOptionPane.showMessageDialog(this,"Please enter a valid date","Invalid Date Error",JOptionPane.ERROR_MESSAGE);
            } else {
                   BAPREPT rp = new BAPREPT();
                  try {
                      rp.createIndividualReport(startDate.getText(), endDate.getText());
                      JOptionPane.showMessageDialog(null, "Report Created in Reports Directory ","Backup successful.",JOptionPane.OK_OPTION);
                      this.dispose();
                  } catch (IOException ex) {
                      Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (PrinterException ex) {
                      Logger.getLogger(StaffReportsScreen.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }
        }
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void quarterlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterlyActionPerformed
            // TODO add your handling code here:
            if(monthly.isSelected()){
                monthly.setSelected(false);
            }
            
            if(yearly.isSelected()){
                yearly.setSelected(false);
            }
    }//GEN-LAST:event_quarterlyActionPerformed

    private void yearlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearlyActionPerformed
        // TODO add your handling code here:
        if(monthly.isSelected()){
            monthly.setSelected(false);
        }
        
        if(quarterly.isSelected()){
            quarterly.setSelected(false);
        }
    }//GEN-LAST:event_yearlyActionPerformed

    private void customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customActionPerformed
        // TODO add your handling code here:
        
        if(custom.isSelected() == true){
            startDate.setEditable(true);
            endDate.setEditable(true);
            monthly.setSelected(false);
            quarterly.setSelected(false);
            yearly.setSelected(false);
        }
        
        
        else{
            
            startDate.setEditable(false);
            endDate.setEditable(false);
            
        }
    }//GEN-LAST:event_customActionPerformed

    private void startDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_startDateFocusGained
        // TODO add your handling code here:
        if (startDate.isEditable()){
             startDate.setText("");
        }
       
    }//GEN-LAST:event_startDateFocusGained

    private void endDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_endDateFocusGained
        // TODO add your handling code here:
        
        if(endDate.isEditable()){
         endDate.setText("");   
        }
        
    }//GEN-LAST:event_endDateFocusGained

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        ShiftManagerStartScreen screen = new ShiftManagerStartScreen();
        screen.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        ReportScreen screen = new ReportScreen();
        screen.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StaffReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffReportsScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffReportsScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bg;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton createButton;
    private javax.swing.JCheckBox custom;
    private javax.swing.JTextField endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton monthly;
    private javax.swing.JRadioButton quarterly;
    private javax.swing.JTextField startDate;
    private javax.swing.JRadioButton yearly;
    // End of variables declaration//GEN-END:variables
}
