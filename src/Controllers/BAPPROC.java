/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;

import domain.TaskLine;
import domain.JobLine;
import domain.JobLine_;
import domain.JobTaskBridge;
import gui.JobsCenterScreen;
import gui.ManageUsersSearchScreen;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
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
    
    public List<TaskLine> getactiveTasks(){
        dm = new DataManagerImpl();
        Collection <JobLine> jl = dm.allJobs();
        List<JobLine> unfinishedJobs = new LinkedList();
        List<JobLine> unfinishedJobs2 = new LinkedList();
        Collection<TaskLine> tasksToDO ;
        
        for(JobLine q : jl){
            Collection<TaskLine> t = q.getTaskLineCollection();
            
            for(TaskLine ts: t){
                if(ts.getStartTime() == null){
                    unfinishedJobs.add(q);
                    break;
                }
            }
        }
        
        
        for(JobLine q : unfinishedJobs){
           Collection<TaskLine> t = q.getTaskLineCollection();
           tasksToDO = new LinkedList();
            
            for(TaskLine ts: t){
                if(ts.getStartTime() == null){
                    tasksToDO.add(ts);
                }
            }
            
            q.setTaskLineCollection(tasksToDO);
            unfinishedJobs2.add(q);
        }
        List<TaskLine> unfinishedTasks = new LinkedList();
        
        for(JobLine uy : unfinishedJobs2){
            Collection <TaskLine> tld = uy.getTaskLineCollection();
            
            for(TaskLine tuy : tld){
             unfinishedTasks.add(tuy);
            }
            
            
        }
        
        
        Collections.sort(unfinishedTasks);
        List<TaskLine> tsks = new LinkedList(unfinishedTasks);
        List<TaskLine> taskss = new LinkedList();
        JobLine eg = tsks.get(0).getJoblineID();
        
        
        
            Iterator<TaskLine> iterator = tsks.iterator();
            TaskLine firstfg = new TaskLine();
            TaskLine secondfg = new TaskLine();
            TaskLine fg = new TaskLine();
            int gbt = 10;
            while(iterator.hasNext()){
                
                    
                    firstfg= iterator.next();
                    JobLine eg2 = firstfg.getJoblineID();
                    
                    if(eg.equals(eg2)){
                        
                        JobTaskBridge ght = dm.findtb(eg.getJobCode(), firstfg.getTaskID());
                        
                        int rank = ght.getTaskSequence();
                        if(rank < gbt){
                            secondfg = firstfg;
                            gbt = rank;
                        }
                        
                        
                               
                        
                        
                        
                    }
                    
                    if(!eg.equals(eg2)){
                        
                        taskss.add(secondfg);
                        eg = eg2;
                        gbt = 10;
                        
                    }
                    
                    
                    
               
            }
            
        
        
        
        return taskss;
        
    }
    
}
