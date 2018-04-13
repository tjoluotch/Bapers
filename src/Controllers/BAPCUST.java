/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import java.util.ArrayList;
import java.util.regex.*;

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
}
