/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.Staff;
import javax.persistence.LockModeType;

import javax.swing.*;

/**
 * @author Daniel
 */
//Accept Job at reception
//Assign Job number
public class BAPACCT {
    
    DataManagerImpl dm = new DataManagerImpl();
    Customer cust;
    public BAPACCT(){
       
    }
    
    public String calAcc() {
         String prefix = "ACC0200";   
    return prefix;
    }
    
    public void createNewCustomer(String forename, String surname, String accountHolderName, 
        String address1, String city, String postcode, String phone){
        Customer customer = new Customer();
        
        customer.setAccountNo(calAcc());
        customer.setForename(forename);
        customer.setSurname(surname);
        customer.setAccountHolderName(accountHolderName);
        customer.setAddress1(address1);
        customer.setCity(city);
        customer.setPostcode(postcode);
        customer.setPhone(phone);
        customer.setValuedCustomer(Boolean.FALSE);
        
        dm.saveCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been added to the database.");
    }

    public void deleteCustomer(Customer c){
       c = new Customer();
        
        
        dm.deleteCustomer(c);
        System.out.println("Customer " + c.getForename() + " " + c.getSurname() + " has been deleted from the database.");
    }
    
    public void updateCustomer(String firstName, String surname, String email,
                                String phone, String address1, String postcode, 
                                 String Acc_holderName){

         dm.getEm().getTransaction().begin();
        cust = dm.getEm().find(Customer.class, firstName);
        dm.getEm().lock(cust, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        dm.getEm().flush();
        cust.setForename(firstName);
        cust.setSurname(surname);
        cust.setEmail(email);
        cust.setPhone(phone);
        cust.setAddress1(address1);
        cust.setPostcode(postcode);
        cust.setAccountHolderName(Acc_holderName);
        dm.getEm().getTransaction().commit();
        
    }

    public Customer searchCustomerByName(JTextField name) {
        String firstName = name.getText();
        //String lastName = sName.getText();
        
      Customer c = dm.findCustomerByName(firstName, null);
      return c;
    }
}
