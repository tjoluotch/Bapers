/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.*;
import java.sql.*;
import javax.swing.*;
import gui.*;

/**
 *
 * @author tjay
 */
public class Controller {
    MyDBConn d = new MyDBConn();
    Connection conn = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Controller() {
    }
    
    //not yet tested by michal standards
    public void loginSystem(JTextField username, JPasswordField password) {
        
       conn = d.open_Connection();
       String user = username.getText();
       String pass = new String (password.getPassword());
        String Sql = "Select * from Staff where username=? and password=?";
        try{
            pst = conn.prepareStatement(Sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
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
    
    public void addCustomer() throws SQLException {
        conn = d.open_Connection();
        st = conn.createStatement();
        try {
            
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(SQLException.class);
        }
    }
}
