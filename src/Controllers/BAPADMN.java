/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import data.DataManagerImpl;
import domain.JobLine;
import domain.Staff;
import gui.ManageUsersSearchScreen;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.LockModeType;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.jbig2.util.log.LoggerFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
        dm = new DataManagerImpl();
        Staff staff = new Staff();
        staff.setUsername(username);
        staff.setForename(forname);
        staff.setSurname(surname);
        staff.setRole(role);
        staff.setPassword(password);
        
        
        dm.saveStaff(staff);
        
    }
    
    public void searchStaff(String search){
        dm = new DataManagerImpl();
        dm.getEm().getTransaction().begin();
        List <Staff> staffList =dm.searchStaffByUsername(search);
        dm.getEm().getTransaction().commit();
        ManageUsersSearchScreen screen = new ManageUsersSearchScreen(staffList);
        screen.setVisible(true);
        
    }
    
    public Staff modifyStaff(String search){
       dm = new DataManagerImpl(); 
       Staff staff= dm.findStaffByUsername(search);
       
       return staff;
       
        
        
    }
    
    public void updateStaff(String username, String Forename, String surname, String password, String role){
        dm = new DataManagerImpl();
      
        
        dm.getEm().getTransaction().begin();
        staffs = dm.getEm().find(Staff.class, username);
        dm.getEm().lock(staffs, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        dm.getEm().flush();
        staffs.setForename(Forename);
        staffs.setSurname(surname);
        if(password.compareTo("jPasswordField1")!=0){
           staffs.setPassword(password); 
        }
        
        staffs.setRole(role);
        dm.getEm().getTransaction().commit();
        
        
        
    }
    
    public void deleteStaff(String username){
        
        
        int dialogue = JOptionPane.showConfirmDialog(frame,"Once Deleted Staff Account cannot be recovered. Are you you want to Delete?","Confirm Delete",JOptionPane.YES_NO_OPTION);
        if (dialogue == JOptionPane.YES_OPTION){
            dm = new DataManagerImpl();
            
            
        
        dm.getEm().getTransaction().begin();
       // dm.getEm().lock(this, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        staffs = dm.getEm().find(Staff.class, username);
        dm.getEm().lock(staffs, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        dm.getEm().flush();
        dm.getEm().remove(staffs);
        dm.getEm().getTransaction().commit();
        
        
        }
        
        else{
            
        }
        
        
    }
    
    public void backupDB( String fileName) throws IOException, InterruptedException{
        
        Process runtimeProcess;
        String savePath =   fileName+".sql\"";
         String executeCmd = "\"C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump.exe\" -u " + "root" + " -p" + "chicken" + " --add-drop-database -B " + "solsoft_DB" + " -r " + savePath;
        try{
            
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                System.out.println("Backup created successfully");
             
            } else {
                System.out.println("Could not create the backup");
            }
        
        
         
         
  
        
        
          }catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error at Backup Restore" + ex.getMessage());
    }
  }
    
   public boolean restoreDB(String source){
       
       String[] executeCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysql.exe","solsoft_DB", "--user=" + "root", "--password=" + "chicken", "-e", " source " + source};
       
        
 
        Process runtimeProcess;
        try {
 
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
 
            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
                return true;
            } else {
                System.out.println("Could not restore the backup");
            }
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Could not restore backup" + ex.getMessage());
        }
 
        return false;
       
   }
    
    
    
    
    
}
