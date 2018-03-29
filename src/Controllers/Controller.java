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
import java.util.Random;

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
    
    public void addCustomer(JTextField firstName, JTextField lastName, JTextField username, JTextField city, JTextField phoneNo, JTextField streetName, JTextField houseNo, JTextField borough, JTextField postcode) throws SQLException {
        conn = d.open_Connection();
        //st = conn.createStatement();
        
        
        String fN = firstName.getText();
        String lN = lastName.getText();
        String uN = username.getText();
        String cty = city.getText();
        
        String phN = phoneNo.getText();
        String stN = streetName.getText();
        String hsN = houseNo.getText();
        String br = borough.getText();
        String pc = postcode.getText();
        
        String custPrefix = "ACC";
        
         Random rand = new Random();
         int n = rand.nextInt(999) + 100;
        
        String customerNu = Integer.toString(n);
        
        String accNo = custPrefix + customerNu;
        
        int defValued = 0;
        
       
        
        try {
            //st.executeUpdate("INSERT INTO Customer " +  "VALUES (" + custPrefix + customerNu + "," + " " + fN + "," + " " + lN + "," + " " + uN + "," + " " + stN + "," + " " + hsN + "," + " " + br + "," + " " + cty + "," + " " + pc + "," + " " + phN + "," + " " + "0" + "," + " " + "none)");
            String sql = "INSERT INTO Customer (account_no, forename, surname, account_holder_name, Address1, Address2, Address3, Town/City, postcode, phone, valued_customer, discount_type)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, accNo);
            pst.setString(2, fN);
            pst.setString(3, lN);
            pst.setString(4, uN);
            pst.setString(5, stN);
            pst.setString(6, hsN);
            pst.setString(7, br);
            pst.setString(8, cty);
            pst.setString(9, pc);
            pst.setString(10, phN);
            pst.setInt(11, defValued);
            pst.setString(12, "none");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer Created Successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
           
        }
    }
}
