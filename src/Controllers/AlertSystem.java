/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Alert;
import domain.JobLine;
import gui.AlertScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Tweetie Pie
 */
public class AlertSystem {
    public void beginAlerts(){
       searchFirstReminder();
        Timer timer = new Timer(21900000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               searchFirstReminder();
               
               
           }
       });
        
        timer.start();  
        AlertScreen screen = new AlertScreen();
        screen.setVisible(true);
        
    }
    
    public void searchFirstReminder(){
        
        Date currentDay = new java.util.Date();
        DataManagerImpl dm = new DataManagerImpl();
        List<JobLine> jl = dm.searchByJobDeadline(currentDay);
        List<JobLine> nearDeadlineList = new LinkedList();
        long oneDay = 86400000;
        
        for(JobLine j: jl){
            
            if(j.getJobDeadline().getTime() - currentDay.getTime() < oneDay){
                
                nearDeadlineList.add(j);
                
               }
        }
        
        for(JobLine j : nearDeadlineList){
            int acount = 0;
            if(acount < nearDeadlineList.size() ){
                
                Alert a = new Alert();
                a.setOrderID(j.getOrderID());
                a.setAccountNo(j.getOrderID().getAccountNo());
                a.setDescription("Job: "+ j.getJobCode().getCode() + " for Account Number: " + j.getOrderID().getAccountNo().getAccountNo() + " is within 24 hours of its deadline : " + j.getJobDeadline().toString()  );
                a.setTarget("Office Manager and Shift Manager");
                a.setBeenSeen(false);
                a.setJoblineID(j);
                dm.saveAlert(a);
                acount+=1;
                
            }
            
            else{
                break;
            }
        }
        
        
        
    }
}
