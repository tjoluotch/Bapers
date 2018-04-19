/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;

import domain.TaskLine;
import gui.JobsCenterScreen;
import gui.ManageUsersSearchScreen;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class BAPPROC {
    
    DataManagerImpl dm = new DataManagerImpl();
    

    public BAPPROC() {
    }
    
    public void getTaskList(){
        
        dm = new DataManagerImpl();
        dm.getEm().getTransaction().begin();
        List <TaskLine> taskLineList = new LinkedList();
        taskLineList = dm.searchbyStartTime();
        dm.getEm().getTransaction().commit();
        JobsCenterScreen screen = new JobsCenterScreen(taskLineList);
        screen.setVisible(true);
        
    }   
    
}
