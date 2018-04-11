/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.Job;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.Task;
import domain.TaskLine;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Daniel
 */
//Accept Job at reception
//Assign Job number
public class BAPACCT {
  
    Collection<TaskLine> tLines = new LinkedList();
    Collection<JobLine> jCollection = new LinkedList();
    
     public BAPACCT(){
        
    }
    
    
    
    
    public void createNewCustomer(String accountNo, String forename, String surname, String accountHolderName, 
            String address1, String address2, String address3, String city, String postcode, String phone){
        Customer customer = new Customer();
        
        customer.setAccountNo(accountNo);
        customer.setForename(forename);
        customer.setSurname(surname);
        customer.setAccountHolderName(accountHolderName);
        customer.setAddress1(address1);
        customer.setAddress2(address2);
        customer.setCity(city);
        customer.setPostcode(postcode);
        customer.setPhone(phone);
        customer.setValuedCustomer(Boolean.FALSE);
        DataManagerImpl dm = new DataManagerImpl();
        dm.saveCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been added to the database.");
    }    
    
    
     public void createOrder( Collection<JobLine> jColl , Customer accountNo){ 
            List<PaymentDetail> paymentDetails = new LinkedList();
        OrderTable order = new OrderTable();
        order.setPaymentDetailCollection(paymentDetails);
        
        for(JobLine j: jColl){
            
            j.setOrderID(order);
        }
        order.setJobLineCollection(jColl);
        Date dateSubmitted = new Date();
        dateSubmitted.setTime(System.currentTimeMillis());
        order.setDateSubmitted(dateSubmitted);
        
        
        float price = 0;
        
        for( JobLine j: jColl){
            price += j.getJobCode().getPrice();
        }
        
        order.setTotalPrice(price);
        
        
        
        DataManagerImpl dm = new DataManagerImpl();
        dm.saveOrder(order);
        
        //jl.setJobCode(jobCode);
    }  
     
     
     public Collection<JobLine> createJobLines(Date date, List<Job> jcodes , String specialInstructions){
         
         jCollection = new LinkedList();
         
         for(Job jc: jcodes){
             JobLine f = new JobLine();
             f.setJobCode(jc);
          
            f.setJobDeadline(date);
        
            f.setSpecialInstructions(specialInstructions);
            
       
            jCollection.add(f);
             
         }
                 
        Collection<JobLine> jobLinesCopy = new LinkedList();
        jobLinesCopy = jCollection;
             
        
         
         for (JobLine j : jCollection){
             
             String jcode = j.getJobCode().getCode();
             
             
             if(jcode.compareTo("ABN54")==0){
                 tLines = new LinkedList();
                 int t1 = 1;
                 int t2 = 2;
                 int t3 = 3;
                 createTaskColl(t1,j);
                 createTaskColl(t2,j);
                 createTaskColl(t3,j);
                 
                 JobLine j2 = j;
                 j2.setTaskLineCollection(tLines);
                 jobLinesCopy.add(j2);
             }
             else if(jcode.compareTo("ACN54")==0){
                 tLines = new LinkedList();
                 int t1 = 1;
                 int t2 = 4;
                 int t3 = 3;
                 createTaskColl(t1,j);
                 createTaskColl(t2,j);
                 createTaskColl(t3,j);
                 
                 JobLine j2 = j;
                 j2.setTaskLineCollection(tLines);
                 jobLinesCopy.add(j2);                 
             }
             else if(jcode.compareTo("ACT108")==0){
                 tLines = new LinkedList();
                 int t1 = 1;
                 int t2 = 5;
                 int t3 = 3;
                 createTaskColl(t1,j);
                 createTaskColl(t2,j);
                 createTaskColl(t3,j);
                 
                 JobLine j2 = j;
                 j2.setTaskLineCollection(tLines);
                 jobLinesCopy.add(j2);
                 
                 
                 
             }
             else if(jcode.compareTo("ACT35")==0){
                 tLines = new LinkedList();
                 int t1 = 6;
                 int t2 = 5;
                 int t3 = 7;
                 createTaskColl(t1,j);
                 createTaskColl(t2,j);
                 createTaskColl(t3,j);
                 
                 JobLine j2 = j;
                 j2.setTaskLineCollection(tLines);
                 jobLinesCopy.add(j);
                 
             }
            else if(jcode.compareTo("B108")==0){
                 tLines = new LinkedList();
                 int t1 = 2;
                 int t2 = 3;
                 createTaskColl(t1,j);
                 createTaskColl(t2,j);
                 JobLine j2 = j;
                 j2.setTaskLineCollection(tLines);
                 jobLinesCopy.add(j2);
                 
                 
                 
             }
           else if (jcode.compareTo("C108 ")==0) {
                tLines = new LinkedList();
                int t1 = 4;
                int t2 = 3;
                createTaskColl(t1,j);
                createTaskColl(t2,j);
                JobLine j2 = j;
                j2.setTaskLineCollection(tLines);
                jobLinesCopy.add(j2);
            }
        }
        
        return jobLinesCopy;
         
     }
     
     public void createTaskColl(int id,  JobLine j ){
         DataManagerImpl dm = new DataManagerImpl();
         
         Task t1 = dm.findTaskById(id);
         TaskLine l1 = new TaskLine();
                  l1.setTaskID(t1);
                  l1.setJoblineID(j);
                  tLines.add(l1);
        }
}
