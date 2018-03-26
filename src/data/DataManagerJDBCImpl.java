/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author DanTe
 */
public class DataManagerJDBCImpl implements DataManager{
    
    @PersistenceContext 
    private EntityManager em;
    
    @Override
    public List<Customer> AllCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    } 
    @Override
    public List<Staff> AllStaff(){
        TypedQuery<Staff> query = em.createNamedQuery("Staff.findAll", Staff.class);
        return query.getResultList();
    }
    @Override
    public List<Job> AllJobs(){
        TypedQuery<Job> query = em.createNamedQuery("Job.findAll", Job.class);
        return query.getResultList();
    }
    @Override
    public List<Task> AllTasks(){
        TypedQuery<Task> query = em.createNamedQuery("Task.findAll", Task.class);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerByForename(String forename) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByForename", Customer.class);
        query.setParameter("forename", forename);
        return query.getSingleResult();
    }
    
    @Override
    public Customer findCustomerBySurname(String surname) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findBySurname", Customer.class);
        query.setParameter("surname", surname);
        return query.getSingleResult();
    }

    @Override
    public Customer findCustomerByAccountHolderName(String AccountHolderName) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByAccountHolderName", Customer.class);
        query.setParameter("account_holder_name", AccountHolderName);
        return query.getSingleResult();
    }

    @Override
    public Customer findCustomerByAccountNumber(String AccountNumber) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByAccountNo", Customer.class);
        query.setParameter("account_no", AccountNumber);
        return query.getSingleResult();
    }

    @Override
    public List<Job> FindJobsByCustomer(Customer customer){
        //ypedQuery<Job> query = em.createNamedQuery("")
        return null;
    }
    @Override
    public List<Job> FindJobsByStaff(Staff staff){
        return null;
    }
    
    @Override
    public Job findJobByCode(String code) {
        TypedQuery<Job> query = em.createNamedQuery("Job.findByCode", Job.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }

    @Override
    public Task findTaskById(String Id) {
        TypedQuery<Task> query = em.createNamedQuery("Task.findByTaskID", Task.class);
        query.setParameter("TaskID", Id);
        return query.getSingleResult();
    }

    @Override
    public Staff findStaffByName(String forename, String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Staff findStaffBySurname(String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Staff findStaffByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void saveCustomer(Customer customer){em.persist(customer);}
    @Override
    public void saveStaff(Staff staff){em.persist(staff);}
    @Override
    public void saveJob(Job job){em.persist(job);}
    @Override
    public void saveTask(Task task){em.persist(task);}
}
