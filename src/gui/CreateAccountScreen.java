/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controllers.BAPACCT;
<<<<<<< HEAD
=======
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import domain.Customer;
>>>>>>> Sylvester'


/**
 *
 * @author Tweetie Pie
 */
public class CreateAccountScreen extends javax.swing.JFrame {

    /**
     * Creates new form CreateAccountScreen
     */
    
    BAPACCT b = new BAPACCT();
    
    public CreateAccountScreen() {
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

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        forename = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        accountHolderName = new javax.swing.JTextField();
<<<<<<< HEAD
        phoneNo = new javax.swing.JTextField();
        postcode = new javax.swing.JTextField();
        adress1 = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        createAccountButton = new javax.swing.JButton();
        Title = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
=======
        telephone = new javax.swing.JTextField();
        postcode = new javax.swing.JTextField();
        adress1 = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        title = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        address2 = new javax.swing.JTextField();
>>>>>>> Sylvester'

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        forename.setText("Forename");
        forename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                forenameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                forenameFocusLost(evt);
            }
        });
        forename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forenameActionPerformed(evt);
            }
        });

        surname.setText("Surname");
        surname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                surnameFocusGained(evt);
            }
        });
        surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameActionPerformed(evt);
            }
        });

        accountHolderName.setText("Account Holder Name");
        accountHolderName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                accountHolderNameFocusGained(evt);
            }
        });
        accountHolderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountHolderNameActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        phoneNo.setText("Contact Number");
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
=======
        telephone.setText("Contact Number");
        telephone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telephoneFocusGained(evt);
            }
        });
        telephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneActionPerformed(evt);
>>>>>>> Sylvester'
            }
        });

        postcode.setText("Postcode");
<<<<<<< HEAD
=======
        postcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                postcodeFocusGained(evt);
            }
        });
>>>>>>> Sylvester'
        postcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postcodeActionPerformed(evt);
            }
        });

        adress1.setText("Address");
        adress1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adress1FocusGained(evt);
            }
        });
        adress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adress1ActionPerformed(evt);
            }
        });

        city.setText("City");
<<<<<<< HEAD
=======
        city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cityFocusGained(evt);
            }
        });
>>>>>>> Sylvester'
        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        createAccountButton.setText("Create Account");
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAccountButtonActionPerformed(evt);
=======
        jButton2.setText("Create Account");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
>>>>>>> Sylvester'
            }
        });

        title.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titile", "Mr", "Mrs", "Ms", "Miss", "Master" }));
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        jLabel1.setText("Logo");

        jButton3.setText("Cancel");

<<<<<<< HEAD
=======
        address2.setText("Address");
        address2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                address2FocusGained(evt);
            }
        });
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });

>>>>>>> Sylvester'
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(surname, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accountHolderName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(forename, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adress1)
<<<<<<< HEAD
                                    .addComponent(city)
                                    .addComponent(phoneNo)
=======
                                    .addComponent(address2)
                                    .addComponent(city)
                                    .addComponent(telephone)
>>>>>>> Sylvester'
                                    .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(createAccountButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< HEAD
                            .addComponent(createAccountButton)
=======
                            .addComponent(jButton2)
>>>>>>> Sylvester'
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountHolderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                        .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 94, Short.MAX_VALUE)))
=======
                        .addComponent(address2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(postcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 36, Short.MAX_VALUE)))
>>>>>>> Sylvester'
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void forenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forenameActionPerformed

    private void surnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameActionPerformed

    private void accountHolderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountHolderNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountHolderNameActionPerformed

<<<<<<< HEAD
    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed
=======
    private void telephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneActionPerformed
>>>>>>> Sylvester'

    private void postcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_postcodeActionPerformed

    private void adress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adress1ActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
<<<<<<< HEAD
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed
=======
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed
>>>>>>> Sylvester'

    private void forenameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forenameFocusGained
        // TODO add your handling code here:
        
        if(forename.getText().compareTo("Forename")==0){
            forename.setText("");
        }
    }//GEN-LAST:event_forenameFocusGained

    private void forenameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forenameFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_forenameFocusLost

    private void surnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameFocusGained
        // TODO add your handling code here:
        if(surname.getText().compareTo("Surname")==0){
            surname.setText("");
        }
    }//GEN-LAST:event_surnameFocusGained

    private void accountHolderNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountHolderNameFocusGained
        // TODO add your handling code here:
        if(accountHolderName.getText().compareTo("Account Holder Name")== 0 );
    }//GEN-LAST:event_accountHolderNameFocusGained

    private void adress1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adress1FocusGained
        // TODO add your handling code here:
        if(adress1.getText().compareTo("Address") ==0 ){
            adress1.setText("");
        }
    }//GEN-LAST:event_adress1FocusGained

    private void address2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_address2FocusGained
        // TODO add your handling code here:
        if(address2.getText().compareTo("Address") == 0){
        address2.setText("");
    }
    }//GEN-LAST:event_address2FocusGained

    private void postcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_postcodeFocusGained
        // TODO add your handling code here:
        if(postcode.getText().compareTo("Postcode")==0){
            postcode.setText("");
        }
    }//GEN-LAST:event_postcodeFocusGained

    private void cityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cityFocusGained
        // TODO add your handling code here:
        if(city.getText().compareTo("")==0){
            city.setText("");
        }
    }//GEN-LAST:event_cityFocusGained

    private void telephoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneFocusGained
        // TODO add your handling code here:
        if(telephone.getText().compareTo("Contact Number")==0){
            telephone.setText("");
        }
    }//GEN-LAST:event_telephoneFocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String ukNumberStr = telephone.getText();
        String parsedNumb = new String();
PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
try {
  PhoneNumber ukNumberProto = phoneUtil.parse(ukNumberStr, "GB");
  parsedNumb = ukNumberProto.toString();
} catch (NumberParseException e) {
  System.err.println("NumberParseException was thrown: " + e.toString());
}


if (parsedNumb !=null && forename.getText().compareTo("Forename")!=0 && surname.getText().compareTo("Surname") !=0 && title.getSelectedItem().toString().compareTo("Title") !=0 && accountHolderName.getText().compareTo("Account Holder Name")!= 0 && adress1.getText().compareTo("Address")!= 0 && address2.getText().compareTo("Address")!= 0 && postcode.getText().compareTo("Postcode") !=0 && city.getText().compareTo("City") !=0 ){
    
    Customer c = new Customer();
    BAPACCT ba = new BAPACCT();
    String accountNo = ba.createAccountNo();
    ba.createNewCustomer(accountNo, forename.getText(), surname.getText(), accountHolderName.getText(), adress1.getText(), address2.getText(), city.getText(), postcode.getText(), parsedNumb, title.getSelectedItem().toString());
    
    
  
    
    
    
    
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void createAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAccountButtonActionPerformed
        // TODO add your handling code here:
        b.createNewCustomer(forename.toString(), surname.toString(), accountHolderName.toString(), adress1.toString(),
                            city.toString(), postcode.toString(), phoneNo.toString());
    }//GEN-LAST:event_createAccountButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreateAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateAccountScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateAccountScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountHolderName;
<<<<<<< HEAD
    private javax.swing.JTextField adress1;
    private javax.swing.JTextField city;
    private javax.swing.JButton createAccountButton;
=======
    private javax.swing.JTextField address2;
    private javax.swing.JTextField adress1;
    private javax.swing.JTextField city;
>>>>>>> Sylvester'
    private javax.swing.JTextField forename;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JLabel jLabel1;
<<<<<<< HEAD
    private javax.swing.JTextField phoneNo;
=======
>>>>>>> Sylvester'
    private javax.swing.JTextField postcode;
    private javax.swing.JTextField surname;
    private javax.swing.JTextField telephone;
    private javax.swing.JComboBox<String> title;
    // End of variables declaration//GEN-END:variables
}
