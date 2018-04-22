/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

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
    public List<Customer> findCustomerByStatus(String status) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByStatus", Customer.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    @Override
    public Customer findCustomerByAccountNumber(String AccountNumber) {
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findByAccountNo", Customer.class);
        query.setParameter("accountNo", AccountNumber);
        return query.getSingleResult();
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
    public List <JobTaskBridge> searchByJobCode(Job code) {
        TypedQuery<JobTaskBridge> query = em.createNamedQuery("JobTaskBridge.findByJobCode", JobTaskBridge.class);
        query.setParameter("jobCode", code);
        return query.getResultList();
    }

    @Override
    public OrderTable findOrderByID(int ID) {
        TypedQuery<OrderTable> query = em.createNamedQuery("OrderTable.findByOrderID", OrderTable.class);
        query.setParameter("orderID", ID);
        return query.getSingleResult();
    }
    
    @Override
    public DiscountPlan findDiscountByID(int ID) {
        TypedQuery<DiscountPlan> query = em.createNamedQuery("DiscountPlan.findByDiscountplanID", DiscountPlan.class);
        query.setParameter("orderID", ID);
        return query.getSingleResult();
    }

    @Override
    public List<OrderTable> findOrderByAccountNumber(Customer AccountNumber) {
        TypedQuery<OrderTable> query = em.createNamedQuery("OrderTable.findByAccountNo", OrderTable.class);
        query.setParameter("accountNo", AccountNumber);
        return query.getResultList();    }

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
    public TaskLine findTaskLineByCode(int tid) {
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findByTasklineID", TaskLine.class);
        query.setParameter("tasklineID", tid);
        return query.getSingleResult();
    }
    
    @Override
    public Task findTaskById(int Id) {
        TypedQuery<Task> query = em.createNamedQuery("Task.findByTaskID", Task.class);
        query.setParameter("taskID", Id);
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
    public void saveOrder(OrderTable order){
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        
    }
    
    
     @Override
    public void saveAlert(Alert a){
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        
    }
    
    
    
    
    
 

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
    public void saveDiscountRate(DiscountPlan d){
       em.getTransaction().begin();
       em.persist(d);
       em.getTransaction().commit();
    }
	
	
	 @Override
    public void deleteCustomer(Customer customer){
        Customer cust = em.find(Customer.class,1);
        
        em.getTransaction().begin();
        em.remove(cust);
        em.getTransaction().commit(); 
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
    
    @Override
    public JobTaskBridge findtb( Job code, Task id) {
        TypedQuery<JobTaskBridge> query = em.createNamedQuery("JobTaskBridge.findOrder", JobTaskBridge.class);
        query.setParameter("jobCode", code);
        query.setParameter("taskID", id);
        return query.getSingleResult();
    }
    

    
    
    
    @Override
    public List<TaskLine> searchbyStartTime(){
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findByNullStartTime", TaskLine.class);
        
        return query.getResultList();
    }
    
     @Override
    public List<JobLine> allJobs(){
        TypedQuery<JobLine> query = em.createNamedQuery("JobLine.findAll", JobLine.class);
        
        return query.getResultList();
    }
    
    @Override
    public List<TaskLine> searchCommencedJobs(Staff staff){
        TypedQuery<TaskLine> query = em.createNamedQuery("TaskLine.findByStarted", TaskLine.class);
        query.setParameter("completedBy", staff);
        return query.getResultList();
    }
    
    @Override
    public List<Customer> customerCount(){
        TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
        
        return query.getResultList();
    }
    
    @Override
    public List<JobLine> searchByJobDeadline(java.util.Date deadline){
        TypedQuery<JobLine> query = em.createNamedQuery("JobLine.findDeadlinesAfterDate", JobLine.class);
        query.setParameter("jobDeadline", deadline);
        
        return query.getResultList();
    }
    
     @Override
    public Staff findStaffByName(String forename, String surname) {
        if(surname.contentEquals("")){
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
    public void saveJob(Job job){
        em.getTransaction().begin();
        em.persist(job);
        em.getTransaction().commit();
    }
	
	@Override
    public void savePayment(PaymentDetail payment){
        em.getTransaction().begin();
        em.persist(payment);
        em.getTransaction().commit();
    }
	
	@Override
    public void saveTask(Task task){
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }
    
    public void saveTaskLine(TaskLine task){
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }
    
    
    @Override
    public List<Staff> searchAllStaff(){
        TypedQuery<Staff> query = em.createNamedQuery("Staff.findAllStaff", Staff.class);
        
        return query.getResultList();
    }
    
     @Override
    public List<Alert> findAlerts(){
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findByBeenSeen", Alert.class);
        query.setParameter("beenSeen", false);
        
        return query.getResultList();
    }
    
     @Override
    public List<OrderTable> findOrders(Customer customer){
        TypedQuery<OrderTable> query = em.createNamedQuery("OrderTable.findByAccountNo", OrderTable.class);
        query.setParameter("accountNo", false);
        
        return query.getResultList();
    }

   
    
    
            
   
        
    }
        
    
    

