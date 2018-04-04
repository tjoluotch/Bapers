/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.JobLine;
import domain.Staff;
import gui.ManageUsersSearchScreen;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class BAPADMN {
    
    DataManagerImpl dm;
    Staff staffs;
    JFrame frame;
    
    public BAPADMN(){
        
    }
    
    public BAPADMN(DataManagerImpl dm){
        this.dm = dm;
    }
    public BAPADMN(DataManagerImpl dm, JFrame frame){
        this.dm = dm;
        this.frame = frame;
    }
    public void createUserAccount(String username, String forname, String surname, String role, String password){
        Staff staff = new Staff();
        staff.setUsername(username);
        staff.setFirstName(forname);
        staff.setSurname(surname);
        staff.setRole(role);
        staff.setPassword(password);
        Collection<JobLine> jobLineCollection = new ArrayList();
        staff.setJobLineCollection(jobLineCollection);
        
        dm.saveStaff(staff);
        
    }
    
    public void searchStaff(String search){
        
        List <Staff> staffList =dm.searchStaffByUsername(search);
        ManageUsersSearchScreen screen = new ManageUsersSearchScreen(staffList);
        screen.setVisible(true);
        
    }
    
    public Staff modifyStaff(String search){
        
       Staff staff= dm.findStaffByUsername(search);
       
       return staff;
       
        
        
    }
    
    public void updateStaff(String username, String firstName, String surname, String password, String role){
        dm = new DataManagerImpl();
      
        staffs = dm.getEm().find(Staff.class, username);
        dm.getEm().getTransaction().begin();
        staffs.setFirstName(firstName);
        staffs.setSurname(surname);
        staffs.setPassword(password);
        staffs.setRole(role);
        dm.getEm().getTransaction().commit();
        
        
        
    }
    
    public void deleteStaff(String username){
        
        
        int dialogue = JOptionPane.showConfirmDialog(frame,"Once Deleted Staff Account cannot be recovered. Are you you want to Delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        if (dialogue == JOptionPane.YES_OPTION){
            dm = new DataManagerImpl();
      
        staffs = dm.getEm().find(Staff.class, username);
        dm.getEm().getTransaction().begin();
        dm.getEm().remove(staffs);
        dm.getEm().getTransaction().commit();
        
        
        }
        
        else{
            
        }
        
        
    }
    
    
    
    
    
}
