/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solsoftbapers2;

import data.*;
import domain.Customer;


public class SolSoftBapers2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        
        /*MyDBConn d = new MyDBConn();
        d.open_Connection();
        DataManager dm = new DataManagerImpl();
    
        List<Customer> allCustomers = dm.AllCustomers();
        
        for(Customer c : allCustomers){
           String cust = "" + c.getForename() + " " + c.getSurname(); 
           System.out.println(cust);
        }*/
        
        
        DataManagerImpl dm = new DataManagerImpl();
        
       // for(Job j : dm.AllJobs()){
         //   System.out.println(j.getCode());
        //}
        
        for(Customer c : dm.AllCustomers()){
           String cust = "" + c.getForename() + " " + c.getSurname(); 
           System.out.println(cust);
        }
        
    
}
    
}
