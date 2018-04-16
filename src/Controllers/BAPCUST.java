/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.*;
import java.util.ArrayList;
import java.util.regex.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class BAPCUST {
    
    DataManagerImpl dm = new DataManagerImpl();
   
    public BAPCUST(){
        
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
    
    public void discountPlanSetFixed(float rate, Customer c){
        DicountPlan d = new DicountPlan();
        //set isFlexible to 0 showing that its false
        short isFlexible = 0;
        //set Task ID to 0 indicating this is fixed and therefore not attached to a particular task
        
        
        d.setIsFlexible(isFlexible);
        d.setRate(rate);
        d.setAccountNo(c);
        dm.saveDiscountRate(d);
        System.out.println("Discount Rate " + rate + " successfully Set for " + c.getForename());
    }
}
