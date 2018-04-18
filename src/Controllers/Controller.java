/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Staff;
import javax.swing.*;
import gui.*;
import java.io.PrintStream;

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
    
    public boolean loginSystem(JTextField username, JPasswordField password) {
       dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0) {
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
                return true;
            } 
        } catch (Exception ex) {
                username.setText("");
                password.setText("");
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void logoutSystem(){
        staff = new Staff();
    }
}
