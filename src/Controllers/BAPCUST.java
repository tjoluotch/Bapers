/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.DiscountPlan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class BAPCUST {
    
    DataManagerImpl dm = new  DataManagerImpl();
    
      public void discountPlanSetFixed(float rate, Customer c){
        DiscountPlan d = new DiscountPlan();
        //set Task ID to 0 indicating this is fixed and therefore not attached to a particular task
        
        d.setRate(rate);
        d.setAccountNo(c);
        dm.saveDiscountRate(d);
        System.out.println("Discount Rate " + rate + " successfully Set for " + c.getForename());
    }



public ArrayList discountRegexp(String s) {
        String regex = "\\(([^)]+)\\)";
        
        Pattern p = Pattern.compile(regex);
        
        Matcher m = p.matcher(s);
        
        ArrayList<String> plans = new ArrayList<>();
        while(m.find()){
          plans.add(m.group(1));
        }
        System.out.println(plans);
        return plans;
    }
	
	
	
	 public void deleteCustomer(Customer c){
       c = new Customer();
        
        
        dm.deleteCustomer(c);
        System.out.println("Customer " + c.getForename() + " " + c.getSurname() + " has been deleted from the database.");
    }

    public Customer searchCustomerByName(JTextField name) {
        String firstName = name.getText();
        //String lastName = sName.getText();
        
      Customer c = dm.findCustomerByName(firstName, null);
      return c;
    }
    
}
