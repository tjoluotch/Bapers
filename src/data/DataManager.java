/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import domain.*;
import java.sql.Date;

/**
 *
 * @author DanTe
 */
public interface DataManager {
    
    List<Customer> AllCustomers();
    List<Staff> AllStaff();
    List<Job> AllJobs();
    List<Task> AllTasks();
    
    Customer findCustomerByName(String forename, String surname);
   
    //this lower method is dum find better search principle
    Customer findCustomerByAccountHolderName(String AccountHolderName);
    Customer findCustomerByAccountNumber(String AccountNumber);
    
    Staff findStaffByName(String forename, String surname);
    Staff findStaffByUsername(String username);
    List<Staff> searchStaffByUsername(String username);
    
    
    OrderTable findOrderByID(int ID);
    OrderTable findOrderByAccountNumber(String AccountNumber);
    
    Job findJobByCode(String code);
    Job findJobByOrderID(int ID);
    
    Task findTaskById(String Id);
    
    
    
    void saveCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    
    void saveStaff(Staff staff);
    
    void saveJob(Job job);
    
    void saveTask(Task task);
    
    public boolean updateStaffRecord(String username, String firstName, String surname, String password, String role);
    public List <TaskLine> individualReport(Date date);
     public List <TaskLine> individualReportBetween(Date startDate, Date endDate);
     public List<TaskLine> summaryReports(Date startDate, Date endDate);
}
