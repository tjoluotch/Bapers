/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;

import javax.swing.*;

/**
 * @author Daniel
 */
//Accept Job at reception
//Assign Job number
public class BAPACCT {
    DataManagerImpl dm;
    public BAPACCT(){
       
    }
    
    public void createNewCustomer(String accountNo, String forename, String surname, String accountHolderName, 
        String address1, String address2, String address3, String city, String postcode, String phone){
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
        
        dm.saveCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been added to the database.");
    }

    public void deleteCustomer(){
        Customer customer = new Customer();
        
        
        dm.deleteCustomer(customer);
        System.out.println("Customer " + customer.getForename() + " " + customer.getSurname() + " has been deleted from the database.");
    }

    public void searchCustomerByName(JTextField name) {
        String firstName = name.getText();
        //String lastName = sName.getText();
        
      dm.findCustomerByName(firstName, null);
    }
}
