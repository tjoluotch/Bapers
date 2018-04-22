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

//Generic controller class
public class Controller {
    //Empty Staff object to be "filled" by the staff member typing in their username
    Staff staff;
    DataManagerImpl dm;
    
    public Controller() {
    }
    //back end for login GUI screen
    public int loginSystem(JTextField username, JPasswordField password) {
       
       int logCode = 0;
       
       dm = new DataManagerImpl();
       String user = username.getText();
       String pass = new String (password.getPassword());
       
       
       //password for all staff in DB is null
        try{
            staff = dm.findStaffByUsername(user);
            if (staff.getPassword().compareTo(pass) == 0) {
                //Code for changing to the next page
                //boolean for login successful
                    logCode = 2;
                    
                if(staff.getRole().compareToIgnoreCase("Office Manager")==0){
                   
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    //wait to see what the letter generation result is
                    
                    screen.setVisible(true);
                     logCode = 1;
                     return logCode;
                }
                
                if(staff.getRole().compareToIgnoreCase("Shift Manager")==0){
                   
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    //wait to see what the letter generation result is
                    
                    screen.setVisible(true);
                    
                     return logCode;
                }
                
                if(staff.getRole().compareToIgnoreCase("Receptionist")==0){
                   
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    //wait to see what the letter generation result is
                    
                    screen.setVisible(true);
                     
                     return logCode;
                }
                
                if(staff.getRole().compareToIgnoreCase("Technician")==0){
                   
                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
                    //wait to see what the letter generation result is
                    
                    screen.setVisible(true);
                     
                     return logCode;
                }
                
            } else {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
                return logCode;
            } 
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE); 
        }
        return logCode;
    }
//    
//    public boolean loginSystem(JTextField username, JPasswordField password) {
//       dm = new DataManagerImpl();
//       String user = username.getText();
//       String pass = new String (password.getPassword());
//       
//        try{
//            staff = dm.findStaffByUsername(user);
//            if (staff.getPassword().compareTo(pass) == 0) {
//                //Code for changing to the next page
//                //Access Privileges:
//                
//                if(staff.getRole().compareToIgnoreCase("Office Manager")==0){
//                    OfficeManagerStartScreen screen = new OfficeManagerStartScreen(staff);
//                    screen.setVisible(true);
//                }
//                
//                if(staff.getRole().compareToIgnoreCase("Shift Manager")==0){
//                    ShiftManagerStartScreen screen = new ShiftManagerStartScreen(staff);
//                    screen.setVisible(true);  
//                }
//                
//                if(staff.getRole().compareToIgnoreCase("Technician")==0){
//                    TechnicianStartScreen screen = new TechnicianStartScreen(staff);
//                    screen.setVisible(true);
//                }
//                
//                if(staff.getRole().compareToIgnoreCase("Receptionist")==0){
//                    ReceptionistStartScreen screen = new ReceptionistStartScreen(staff);
//                    screen.setVisible(true);  
//                }
//                return true;
//            } 
//        } catch (Exception ex) {
//                username.setText("");
//                password.setText("");
//                JOptionPane.showMessageDialog(null,"Invalid credentials, Please enter correct credentials!", "Access Denied", JOptionPane.ERROR_MESSAGE);
//        }
//        return false;
//    }
    
    public void logoutSystem(){
        staff = new Staff();
    }
}
