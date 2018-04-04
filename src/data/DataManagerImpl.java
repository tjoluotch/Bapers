/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author DanTe
 */
public class DataManagerImpl implements DataManager{
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BapersPU");
   
    @PersistenceContext 
    private EntityManager em = emf.createEntityManager();
    
    @Override
    public EntityManager getEntityManager(){
        return em;
    }
    
    @Override
    public List<Customer> allCustomers(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        return query.getResultList();
    } 
    @Override
    public List<Staff> allStaff(){
        TypedQuery<Staff> query = em.createNamedQuery("Staff.findAll", Staff.class);
        return query.getResultList();
    }
    @Override
    public List<Job> allJobs(){
        TypedQuery<Job> query = em.createNamedQuery("Job.findAll", Job.class);
        return query.getResultList();
    }
    @Override
    public List<Task> allTasks(){
        TypedQuery<Task> query = em.createNamedQuery("Task.findAll", Task.class);
        return query.getResultList();
    }
    
    @Override
    public Customer findCustomerByName(String forename, String surname) {
        if(surname == null){
            TypedQuery<Customer> query = em.createNamedQuery("Customer.findByForename", Customer.class);
            query.setParameter("forename", forename);
            return query.getSingleResult();
        } else if(forename == null){
            TypedQuery<Customer> query = em.createNamedQuery("Customer.findBySurname", Customer.class);
            query.setParameter("surname", surname);
            return query.getSingleResult();
        } else {
            TypedQuery<Customer> query = em.createNamedQuery("Customer.findByName", Customer.class);
            query.setParameter("forename", forename).setParameter("surname", surname);
            return query.getSingleResult();
        }
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
    public Staff findStaffByName(String forename, String surname) {
        if(surname == null){
            TypedQuery<Staff> query = em.createNamedQuery("Staff.findByForename", Staff.class);
            query.setParameter("forename", forename);
            return query.getSingleResult();
        } else if(forename == null){
            TypedQuery<Staff> query = em.createNamedQuery("Staff.findBySurname", Staff.class);
            query.setParameter("surname", surname);
            return query.getSingleResult();
        } else {
            TypedQuery<Staff> query = em.createNamedQuery("Staff.findByName", Staff.class);
            query.setParameter("forename", forename).setParameter("surname", surname);
            return query.getSingleResult();
        }
    }

    @Override
    public Staff findStaffByUsername(String username) {
        TypedQuery<Staff> query = em.createNamedQuery("Staff.findByUsername", Staff.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    @Override
    public OrderTable findOrderByID(int ID) {
        TypedQuery<OrderTable> query = em.createNamedQuery("OrderTable.findByOrderID", OrderTable.class);
        query.setParameter("orderID", ID);
        return query.getSingleResult();
    }

    @Override
    public OrderTable findOrderByAccountNumber(String AccountNumber) {
        TypedQuery<OrderTable> query = em.createNamedQuery("OrderTable.findByAccountNo", OrderTable.class);
        query.setParameter("account_no", AccountNumber);
        return query.getSingleResult();    
    }

    @Override
    public Job findJobByOrderID(int ID) {
        TypedQuery<Job> query = em.createNamedQuery("Job.findByOrderID", Job.class);
        query.setParameter("orderID", ID);
        return query.getSingleResult();
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
    public void saveCustomer(Customer customer){
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
    }
    @Override
    public void saveStaff(Staff staff){
        em.getTransaction().begin();
        em.persist(staff);
        em.getTransaction().commit();
    }
    @Override
    public void saveJob(Job job){
        em.getTransaction().begin();
        em.persist(job);
        em.getTransaction().commit();
    }
    @Override
    public void saveTask(Task task){
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }
}
