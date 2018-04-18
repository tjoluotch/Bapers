/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Alert;
import domain.Customer;
import domain.Job;
import domain.JobLine;
import domain.JobTaskBridge;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.Task;
import domain.TaskLine;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import javax.swing.JTable;
import javax.swing.JTextField;

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
    
     
      public void deleteCustomer(Customer c){
          DataManagerImpl dm = new DataManagerImpl();
       c = new Customer();
        
        
        dm.deleteCustomer(c);
        System.out.println("Customer " + c.getForename() + " " + c.getSurname() + " has been deleted from the database.");
    }

    public Customer searchCustomerByName(JTextField name) {
         DataManagerImpl dm = new DataManagerImpl();
        String firstName = name.getText();
        //String lastName = sName.getText();
        
      Customer c = dm.findCustomerByName(firstName, null);
      return c;
    }
    
    
    
    public void createNewCustomer(String accountNo, String forename, String surname, String accountHolderName, 
            String address1, String address2, String city, String postcode, String phone, String title){
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
        customer.setTitle(title);
        customer.setStatus("Active");
        DataManagerImpl dm = new DataManagerImpl();
        dm.saveCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been added to the database.");
    }  
    
    
    public void createNewCustomerPriv(String accountNo, String forename, String surname, String accountHolderName, 
            String address1, String address2, String city, String postcode, String phone, String title){
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
        customer.setTitle(title);
        DataManagerImpl dm = new DataManagerImpl();
        dm.saveCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been added to the database.");
    }  
    
    
    public String createAccountNo(){
       
       String account;
       DataManagerImpl dm = new DataManagerImpl();
       int customerCount = 0;
       customerCount = dm.AllCustomers().size();
       
           
           String number =  String.format("%04d", customerCount + 1);
           
            
            account = "ACC"+number;
            
            
       
       
       
       
       return account;
    }
    
    
     public void createOrder( Collection<JobLine> jColl , Customer accountNo){ 
            List<PaymentDetail> paymentDetails = new LinkedList();
        OrderTable order = new OrderTable();
        order.setAccountNo(accountNo);
        //order.setPaymentDetailCollection(paymentDetails);
        Collection<Alert> al= new LinkedList();
        order.setAlertCollection(al);
        
        for(JobLine j: jColl){
            
       
            
            Collection<TaskLine> tl = j.getTaskLineCollection();
            long tasksExpectedDuration = 0;
            for(TaskLine t : tl){
                
               tasksExpectedDuration += t.getTaskID().getExpectedDuration();
                
            }
            if(j.getJobDeadline().getTime() < System.currentTimeMillis() + tasksExpectedDuration ){
                
                j.setOrderID(order);
            
            Alert a = new Alert();
             a.setOrderID(order);
             a.setAccountNo(order.getAccountNo());
             a.setDescription("New job alert. Job code: "+ j.getJobCode().getCode() + " Account Number: " + accountNo.getAccountNo() + " Deadline : " + j.getJobDeadline().toString() + ". Warning Job expected completion time is after the deadline"  );
             a.setTarget("Office Manager and Shift Manager");
             a.setBeenSeen(false);
             a.setJoblineID(j);
             
             DataManagerImpl dm = new DataManagerImpl();
             order.getAlertCollection().add(a);
                
            }
            
            else{
                
                j.setOrderID(order);
            
            Alert a = new Alert();
             a.setOrderID(order);
             a.setAccountNo(order.getAccountNo());
             a.setDescription("New job alert. Job code: "+ j.getJobCode().getCode() + " Account Number: " + accountNo.getAccountNo() + " Deadline : " + j.getJobDeadline().toString()  );
             a.setTarget("Shift Manager");
             a.setBeenSeen(false);
             a.setJoblineID(j);
             
             DataManagerImpl dm = new DataManagerImpl();
             order.getAlertCollection().add(a);
                
            }
                
                
            
            
             
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
                 
                 
             
          Collection<JobLine> jCollection2 = new LinkedList();
          jCollection2 = jCollection;
          
        
         
         for (JobLine j : new LinkedList<JobLine>(jCollection)){
             
             String jcod = j.getJobCode().getCode();
             Job jcode = j.getJobCode();
             
             
             if(jcod.compareTo("ABN54")==0){
                 DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
                 
                 
                 
                 
             }
             else if(jcod.compareTo("ACN54")==0){
                 DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
                 
                 
                 
             }
             else if(jcod.compareTo("ACT108")==0){
                 DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
                 
                 
                 
             }
             else if(jcod.compareTo("ACT35")==0){
                 DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
                 
                 
                 
             }
            else if(jcod.compareTo("B108")==0){
                 DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
                 
                 
                 
             }
           else if (jcod.compareTo("C108 ")==0) {
                DataManagerImpl dm = new DataManagerImpl();
                Collection<JobTaskBridge> jtc = dm.searchByJobCode(jcode);
                Collection<TaskLine> tb = createTaskColl(jtc,j);
                j.setTaskLineCollection(tb);
            }
        }
            
         
         
         
         return jCollection;
         
     }
     
     public Collection<TaskLine>  createTaskColl(Collection<JobTaskBridge> jtb,  JobLine j ){
         DataManagerImpl dm = new DataManagerImpl();
         Collection<TaskLine> tl = new LinkedList();
        
         for (JobTaskBridge t: jtb){
             Task t1 = t.getTaskID();
         TaskLine l1 = new TaskLine();
                  l1.setPrice(t1.getPrice());
                  l1.setJoblineID(j);
                  l1.setTaskID(t1);
                   tl.add(l1);
         
         }
         
         
         return tl;
         
         
         
}
     
     public Collection<JobLine> getOrderJobLines(OrderTable o, JTable j ){
         
         Collection<JobLine> jobList = o.getJobLineCollection();
         
         return jobList;
         
         
        
         
         
     }
}

