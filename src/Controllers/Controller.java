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
    public void loginSystem(JTextField username, JPasswordField password) {     
       dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       
//        if(user.equals("")||pass.equals("")) {
//        JOptionPane.showMessageDialog(null,"Some Fields Are Empty!", "Access Denied", JOptionPane.ERROR_MESSAGE);
//        }
       //password for all staff in DB is null
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0) {
                //JOptionPane.showMessageDialog(null, "Welcome");
                //Code for changing to the next page
                //Access Privileges:
                
                if(staff.getRole().compareToIgnoreCase("Office Manager")==0){
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    screen.setVisible(true);
                }
                
                if(staff.getRole().compareToIgnoreCase("Shift Manager")==0){
                    ShiftManagerStartScreen screen = new ShiftManagerStartScreen(staff);
                    screen.setVisible(true);  
                }
                
                if(staff.getRole().compareToIgnoreCase("Technician")==0){
                    TechnicianStartScreen screen = new TechnicianStartScreen(staff);
                    screen.setVisible(true);
                }
                
                if(staff.getRole().compareToIgnoreCase("Receptionist")==0){
                    ReceptionistStartScreen screen = new ReceptionistStartScreen(staff);
                    screen.setVisible(true);  
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
            } 
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,"Some Fields Are Empty!", "Access Denied", JOptionPane.ERROR_MESSAGE);  
        }
    }
    
    public void logoutSystem(){
        staff = new Staff();
    }
}
