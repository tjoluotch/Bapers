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

    public boolean deleteCustomer(String id){
        boolean deleted;
       Customer c = dm.getEm().find(Customer.class, id); 
        
        //dm.deleteCustomer(c);
        dm.getEm().getTransaction().begin();
        dm.getEm().remove(c);
        dm.getEm().getTransaction().commit(); 
        System.out.println("Customer " + c.getForename() + " " + c.getSurname() + " has been deleted from the database.");
        deleted = true;
        return deleted;
    }
    
    public boolean updateCustomer(JTextField fname,JTextField surnametextfield, JTextField emailTextField,
                               JTextField postcodeTextField, JTextField address1TxtField, JTextField phoneTextField, 
                                 JTextField accHolderNameTextField, String id){
        
         boolean update = false;
            
         Customer c = dm.getEm().find(Customer.class, id);
       
        String cfn = fname.getText();
           String cln = surnametextfield.getText();
           String cacn = accHolderNameTextField.getText();
           String cpc = postcodeTextField.getText();
           String cadr = address1TxtField.getText();
           String cphn = phoneTextField.getText();
           String cemail = emailTextField.getText();
       
      dm.getEm().getTransaction().begin();
      c.setAccountHolderName(cacn);
      c.setAddress1(cadr);
      c.setEmail(cemail);
      c.setForename(cfn);
      c.setSurname(cln);
      c.setPostcode(cpc);
      c.setPhone(cphn);
      dm.getEm().getTransaction().commit();
      
      update = true;
      return update;
    
    }

    public Customer searchCustomerByName(JTextField name) {
        String firstName = name.getText();
        //String lastName = sName.getText();
        
      Customer c = dm.findCustomerByName(firstName, null);
      return c;
    }
}
