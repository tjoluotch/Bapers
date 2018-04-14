/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Alert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

/**
 *
 * @author Tweetie Pie
 */
public class AlertSystem {
    public void beginAlerts(){
       
       Timer timer = new Timer(1000, new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
               DataManagerImpl dm = new DataManagerImpl();
               List<Alert> al = dm.findAlerts();
               
               
           }
       });
          
        
        timer.start();  
         }
    
    
}
