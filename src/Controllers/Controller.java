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
import java.awt.HeadlessException;
import javax.persistence.LockModeType;

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
    public void loginSystem(JTextField username, JPasswordField password, JComboBox box) {
        
       dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       String role = new String(box.getSelectedItem().toString());
       
       //password for all staff in DB is null
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0&& staff.getRole().compareTo(role) == 0 ) {
                
                if(staff.getLoggedOn() == false){
                    
                    JOptionPane.showMessageDialog(null, "Welcome");
                //Code for changing to the next page
                
                if(role.compareToIgnoreCase("Office Manager")==0){
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    screen.setVisible(true);
                    AlertSystem as = new AlertSystem();
                    as.beginAlerts();
                    dm.getEm().getTransaction().begin();
                    dm.getEm().lock(staff, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
                    staff.setLoggedOn(true);
                    dm.getEm().getTransaction().commit();
                    
                    
                }
                
                if(role.compareToIgnoreCase("Shift Manager")==0){
                    ShiftManagerStartScreen screen = new ShiftManagerStartScreen(staff);
                    screen.setVisible(true);
                    
                }
                
                if(role.compareToIgnoreCase("Receptionist")==0){
                    ShiftManagerStartScreen screen = new ShiftManagerStartScreen(staff);
                    screen.setVisible(true);
                    
                }
                
                if(role.compareToIgnoreCase("Technician")==0){
                    ShiftManagerStartScreen screen = new ShiftManagerStartScreen(staff);
                    screen.setVisible(true);
                    
                }
                    
                }
                
                else{
                    JOptionPane.showMessageDialog(null,"User is a;ready logged in at another terminal. Please log off before retrying", "Access Denied", JOptionPane.OK_OPTION);
                }
                
                //Welcome w=new Welcome ();
                //w.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
            } 
        } catch (HeadlessException ex) {
        JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void logoutSystem(){
        staff = new Staff();
    }
}
