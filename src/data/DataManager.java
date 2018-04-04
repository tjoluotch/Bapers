/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import domain.*;
import javax.persistence.EntityManager;

/**
 *
 * @author DanTe
 */
public interface DataManager {
    
    EntityManager getEntityManager();
    
    List<Customer> allCustomers();
    List<Staff> allStaff();
    List<Job> allJobs();
    List<Task> allTasks();
    
    Customer findCustomerByName(String forename, String surname);
    Customer findCustomerByAccountHolderName(String AccountHolderName);
    Customer findCustomerByAccountNumber(String AccountNumber);
    
    Staff findStaffByName(String forename, String surname);
    Staff findStaffByUsername(String username);
    
    OrderTable findOrderByID(int ID);
    OrderTable findOrderByAccountNumber(String AccountNumber);
    
    Job findJobByCode(String code);
    Job findJobByOrderID(int ID);
    
    Task findTaskById(String Id);
    
    
    
    void saveCustomer(Customer customer);
    void saveStaff(Staff staff);
    void saveJob(Job job);
    void saveTask(Task task);
}
