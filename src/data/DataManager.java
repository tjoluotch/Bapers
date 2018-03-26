/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;
import domain.*;

/**
 *
 * @author DanTe
 */
public interface DataManager {
    
    List<Customer> AllCustomers();
    List<Staff> AllStaff();
    List<Job> AllJobs();
    List<Task> AllTasks();
    
    List<Job> FindJobsByCustomer(Customer customer);
    List<Job> FindJobsByStaff(Staff staff);
    
    Customer findCustomerByForename(String forename);
    Customer findCustomerBySurname(String surname);
    Customer findCustomerByAccountNumber(String AccountNumber);
    Customer findCustomerByAccountHolderName(String AccountHolderName);
    
    Staff findStaffByName(String forename, String surname);
    Staff findStaffBySurname(String surname);
    Staff findStaffByUsername(String username);
    
    Job findJobByCode(String code);
    
    Task findTaskById(String Id);
    
    void saveCustomer(Customer customer);
    void saveStaff(Staff staff);
    void saveJob(Job job);
    void saveTask(Task task);
}
