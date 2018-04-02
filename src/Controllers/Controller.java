/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.*;
import Staff.Staff;
import java.sql.*;
import javax.swing.*;
import gui.*;
import java.awt.Component;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tjay
 */
public class Controller {
    MyDBConn d = new MyDBConn();
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Component rootPane;
    Staff staff;
    
    public Controller() {
    }
    
    //not yet tested by michal standards
    public void loginSystem(JTextField username, JPasswordField password,JComboBox<String> DropDown) {
        
       conn = d.open_Connection();
        String user = username.getText();
        String pwd = new String (password.getPassword());
        String uOption = DropDown.getSelectedItem().toString();
        String Sql = "Select * from Staff where username=? and password=?";
        
        if(user.equals("")||pwd.equals("")||uOption.equals("Select")) {
            JOptionPane.showMessageDialog(rootPane, "Some Fields Are Empty", "Error", 1);
        }else{
            try{
                pst = conn.prepareStatement(Sql);
                pst.setString(1,user);
                pst.setString(2,pwd);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    String s1 = rs.getString("role");
                    String un = rs.getString("username");
                    if(uOption.equalsIgnoreCase("Office Manager") && s1.equalsIgnoreCase("Office Manager")) {
                        staff = new Staff(rs.getString("username"), rs.getString("forename"), rs.getString("surname"), rs.getString("role"));
                        OfficeManagerStartScreen om = new OfficeManagerStartScreen(staff);
                        
                        om.setStaff(staff);
                        om.setVisible(true);
                        
                        
                        
                    }
                    if(uOption.equalsIgnoreCase("Shift Manager")&& s1.equalsIgnoreCase("Shift Manager")) {
                        ShifManagerStartScreen sm = new ShifManagerStartScreen(un);
                        sm.setVisible(true);
                        staff = new Staff(rs.getString("username"), rs.getString("forename"), rs.getString("surname"), rs.getString("role"));
                    }
                    if(uOption.equalsIgnoreCase("Receptionist")&& s1.equalsIgnoreCase("Receptionist")) {
                        ReceptionistStartScreen rp = new ReceptionistStartScreen(un);
                        rp.setVisible(true);
                        staff = new Staff(rs.getString("username"), rs.getString("forename"), rs.getString("surname"), rs.getString("role"));
                    }
                    if(uOption.equalsIgnoreCase("Technician")&& s1.equalsIgnoreCase("Technician")) {
                        TechnicianStartScreen tc = new TechnicianStartScreen(un);
                        tc.setVisible(true);
                        staff = new Staff(rs.getString("username"), rs.getString("forename"), rs.getString("surname"), rs.getString("role"));
                    }
//                    if( uOption != s1) {
//                        JOptionPane.showMessageDialog(rootPane, "Invalid User Type! Please Select Correct User.", "Invalid User Type Error", 1);
//                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Invalid credentials, Please enter correct credentials!", "Login Error", 1);
                }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }
    
    //Insert Task Into DB:
     public Boolean add(JTextField txtDescr, JComboBox<String> txtDept, JTextField txtShelf, JTextField txtPrice, JTextField txtDur, JComboBox<String> txtStatus, JTextField txtComm) {
        String descr = txtDescr.getText();
        String dept = txtDept.getSelectedItem().toString();
        String shelf = txtShelf.getText();
        String price = txtPrice.getText();
        String dur = txtDur.getText();
        String status = txtStatus.getSelectedItem().toString();
        String comm = txtComm.getText();
        //SQL STATEMENT
        String sql = "INSERT INTO Task (description, department, shelf, `price(£)`, `expected_duration(min)`, status, additional_comments) VALUES (?,?,?,?,?,?,?)";

        try {
            //ESTABLISH CONNECTION
            conn = d.open_Connection();

            // PREPARED STATEMENT
            PreparedStatement st = conn.prepareStatement(sql);
            
            //BINDING DATA TO THE STATEMENT
            st.setString(1, descr);
            st.setString(2, dept);
            st.setString(3, shelf);
            st.setString(4, price);
            st.setString(5, dur);
            st.setString(6, status);
            st.setString(7, comm);
            
            //EXECUTE STATEMENT
            st.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    //Retrieve Task Data from the DB:
    public DefaultTableModel getData() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Task ID");
        dm.addColumn("Description");
        dm.addColumn("Department");
        dm.addColumn("Shelf");
        dm.addColumn("Price(£)");
        dm.addColumn("Duration (min)");
        dm.addColumn("Status");
        dm.addColumn("Comments");
        
        //SQL STATEMENT
        String sql = "SELECT * FROM Task";

        try {
            //ESTABLISH CONNECTION
            conn = d.open_Connection();

            //PREPARED STATEMENT
            Statement s = conn.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                String id = rs.getString(1);
                String descr = rs.getString(2);
                String dept = rs.getString(3);
                String shelf = rs.getString(4);
                String price = rs.getString(5);
                String dur = rs.getString(6);
                String status = rs.getString(7);
                String comm = rs.getString(8);
                
                dm.addRow(new String[]{id, descr, dept, shelf, price, dur, status, comm});
            }

            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

    //Update Task Data in the DB:
    public Boolean update(String id, JTextField txtDescr, JComboBox<String> txtDept, JTextField txtShelf, JTextField txtPrice, JTextField txtDur, JComboBox<String> txtStatus, JTextField txtComm) {
//        String id = txtTaskID.getText();
        String descr = txtDescr.getText();
        String dept = txtDept.getSelectedItem().toString();
        String shelf = txtShelf.getText();
        String price = txtPrice.getText();
        String dur = txtDur.getText();
        String status = txtStatus.getSelectedItem().toString();
        String comm = txtComm.getText();

        //SQL STMT
        String sql = "UPDATE Task SET description = ? , department = ? , shelf = ? ,"
                + "`price(£)` = ? , `expected_duration(min)` = ? , status = ? , "
                + "additional_comments = ? "
                + "WHERE TaskID = ?";
        //String sql = "UPDATE Task SET description ='" + descr + "',department='" + dept + "',shelf='" + shelf + "' ,price(£)='" + price + "',expected_duration(min)='" + dur + "',status='" + status + "',additional_comments='" + comm + "' WHERE TaskID='" + id + "'";
        try {
            //ESTABLISH CONNECTION
            conn = d.open_Connection();

            //PREPARED STATEMENT
            PreparedStatement st = conn.prepareStatement(sql);
            
            //BINDING DATA TO THE STATEMENT
            st.setString(1, descr);
            st.setString(2, dept);
            st.setString(3, shelf);
            st.setString(4, price);
            st.setString(5, dur);
            st.setString(6, status);
            st.setString(7, comm);
            st.setString(8, id);

            //EXECUTE STATEMENT
            st.execute();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //Delete Task Data in the DB:
    public Boolean delete(String id) {
        //SQL STMT
        String sql="DELETE FROM Task WHERE TaskID = ?";
        
        try
        {
            //ESTABLISH CONNECTION
            conn = d.open_Connection();

            //STATEMENT
            PreparedStatement st=conn.prepareStatement(sql);

            //BINDING DATA TO THE STATEMENT
            st.setString(1, id);
           
            //EXECUTE
            st.execute();

            return true;

        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    //Retrieve Status of Task from the DB:
    public DefaultTableModel getStatusData(JComboBox<String> txtStatus) {
        //GET STRING
        String statusCB = txtStatus.getSelectedItem().toString();
        
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Task ID");
        dm.addColumn("Description");
        dm.addColumn("Department");
        dm.addColumn("Shelf");
        dm.addColumn("Price(£)");
        dm.addColumn("Duration (min)");
        dm.addColumn("Status");
        dm.addColumn("Comments");
        
        //SQL STATEMENT
        String sql = "SELECT * FROM Task WHERE status = ?";

        try {
            //ESTABLISH CONNECTION
            conn = d.open_Connection();

            //PREPARED STATEMENT
            PreparedStatement st = conn.prepareStatement(sql);
            
            //BINDING DATA TO THE STATEMENT
            st.setString(1, statusCB);
            
            //EXECUTE QUERY
            ResultSet rs = st.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                String id = rs.getString(1);
                String descr = rs.getString(2);
                String dept = rs.getString(3);
                String shelf = rs.getString(4);
                String price = rs.getString(5);
                String dur = rs.getString(6);
                String status = rs.getString(7);
                String comm = rs.getString(8);
                
                dm.addRow(new String[]{id, descr, dept, shelf, price, dur, status, comm});
            }

            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
}
    

