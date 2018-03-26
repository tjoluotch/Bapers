/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author tjay
 */
public class MyDBConn implements DBConnectivity {
       
        public MyDBConn(){
            
        }
        Connection myConn = null;
        
       @Override
        public Connection open_Connection() {
     
        String user = "root"; //Enter your user (normally root)
        String pass = "root"; // Enter your password (for sheena it will be HPrules001)

        try {
            // 1. Get a connection to database
            Class.forName("com.mysql.jdbc.Driver");
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/solsoft_DB", user, pass);
            JOptionPane.showMessageDialog(null, "Connected to the Database");
            return myConn;
        } catch (Exception exc) {
            exc.printStackTrace();
            JOptionPane.showMessageDialog(null, exc);
            return myConn;
        } 
     }
    
}
