/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.*;
import data.DataManagerImpl;
import domain.Customer;
import domain.Staff;
import java.sql.*;
import javax.swing.*;
import gui.*;

/**
 *
 * @author tjay
 */
public class Controller {
    
    public Controller() {
    }
    
    //not yet tested by michal standards
    public void loginSystem(JTextField username, JPasswordField password) {
        
       DataManagerImpl dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       
       //password for all staff in DB is null
       Staff staff;
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0) {
                JOptionPane.showMessageDialog(null, "Welcome");
                //Code for changing to the next page
                Welcome w=new Welcome ();
                w.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
            } 
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);  
        }
    }
    
    public void addCustomer(){
        Customer newCust = new Customer();
        DataManagerImpl dm = new DataManagerImpl();
        
        dm.saveCustomer(newCust);
    }
}
