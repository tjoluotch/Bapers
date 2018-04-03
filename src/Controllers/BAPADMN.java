/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.JobLine;
import domain.Staff;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Daniel
 */
public class BAPADMN {
    
    DataManagerImpl dm;
    public BAPADMN(DataManagerImpl dm){
        this.dm = dm;
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
        Staff staff = dm.findStaffByUsername(search);
        
    }
}
