/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.Staff;
import javax.swing.*;
import gui.*;

/**
 *
 * @author tjay
 */
public class Controller {
    //Empty Staff object to be "filled" by the staff member typing in their username
    Staff staff;
    DataManagerImpl dm;
    
    
    
    public Controller() {
    }
    
    //not yet tested by michal standards
    // return int 1 if office manager logs in, return 
    public int loginSystem(JTextField username, JPasswordField password, JComboBox box) {
       
       int logCode = 0;
       
       dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       String role = new String(box.getSelectedItem().toString());
       
       //password for all staff in DB is null
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0&& staff.getRole().compareTo(role) == 0) {
                JOptionPane.showMessageDialog(null, "Welcome");
                //Code for changing to the next page
                //boolean for login successful
                
                
                if(role.compareToIgnoreCase("Office Manager")==0){
                   
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    //wait to see what the letter generation result is
                    
                    screen.setVisible(true);
                     logCode = 1;
                     return logCode;
                }
                
            } else {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
                return logCode;
            } 
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);  
        }
        return logCode;
    }
    
    public void logoutSystem(){
        staff = new Staff();
    }
}
