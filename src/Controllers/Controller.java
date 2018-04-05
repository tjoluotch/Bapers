/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import javax.persistence.*;
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
        dm = new DataManagerImpl();
    }
    
    //not yet tested by michal standards
    public void loginSystem(JTextField username, JPasswordField password) {
        
       
       String user = username.getText();
       String pass = new String (password.getPassword());
       
       //password for all staff in DB is null
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
    
    public void logoutSystem(){
        staff = new Staff();
    }
    
    //JPA EXAMPLE
    public void connectionCheck(){
        //methods called from a DataManagerImpl object return objects of the respective type
        for(Customer c : dm.allCustomers()){
           //Concurrency control system:
           //dm.getEntityManager().lock(c, LockModeType.OPTIMISTIC); //OPTIMISTIC IS FOR READING DATABASE
           //dm.getEntityManager().lock(c, LockModeType.OPTIMISTIC_FORCE_INCREMENT); //IS FOR WRITING TO DATABSE
           String cust1 = c.getForename() + " " + c.getSurname() + "\n"; 
           //dm.getEntityManager().flush(); //updates the database
           System.out.println(cust1);
        }
    }
    
    public void Receptionist(){
        BAPACCT acct = new BAPACCT(dm);
        //acct.createNewCustomer("2", "Peter", "Parker", "Parker.Inc", "20 Ingram Street", "Manhattan", null, "New York", "N3WY0RK", "12345");
        }
    
}
