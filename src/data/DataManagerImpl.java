/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.*;
import java.sql.Date;
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

    public EntityManager getEm() {
        return em;
    }
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BapersPU");
   
    @PersistenceContext 
    private EntityManager em = emf.createEntityManager();
    
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
    public List <Staff> searchStaffByUsername(String username) {
        TypedQuery<Staff> query = em.createNamedQuery("Staff.searchByUsername", Staff.class);
        query.setParameter("username", username);
        return query.getResultList();
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
        return query.getSingleResult();    }

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
    public void saveCustomer(Customer customer){em.persist(customer);}
    
    @Override
    public void deleteCustomer(Customer customer){
        Customer cust = em.find(Customer.class,1);
        
        em.getTransaction().begin();
        em.remove(cust);
        em.getTransaction().commit(); 
    }
    
    @Override
    public void saveStaff(Staff staff){
        em.getTransaction().begin();
        em.persist(staff);
        em.getTransaction().commit();
        
    }
    @Override
    public void saveJob(Job job){em.persist(job);}
    @Override
    public void saveTask(Task task){em.persist(task);}

    @Override
    public boolean updateStaffRecord(String username, String firstName, String surname, String password, String role) {
        
    
        TypedQuery<Staff> query = em.createNamedQuery("Staff.updateStaff", Staff.class);
        query.setParameter("forename", firstName);
        query.setParameter("surname", surname);
        query.setParameter("password", password);
        query.setParameter("role", role);
        query.setParameter("username", username);
        query.executeUpdate();
        
        return true;//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List <TaskLine> individualReport(Date date) {
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findPerformanceReport", TaskLine.class);
        query.setParameter("startTime", date);
        return query.getResultList();
    }
    
    @Override
    public List <TaskLine> individualReportBetween(Date startDate, Date endDate) {
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findBetweenDates", TaskLine.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    @Override
    public List<TaskLine> summaryReports(Date startDate, Date endDate) {
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findBetweenDates2", TaskLine.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
    
    
        
    }
        
    
    

