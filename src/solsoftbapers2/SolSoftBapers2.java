/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solsoftbapers2;

import Controllers.*;
import data.*;
import domain.Customer;


public class SolSoftBapers2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    public static void main(String[] args) {
        //Controller controller = new Controller();
        String test = "(trevor12345)";
        BAPCUST b = new BAPCUST();
        b.discountRegexp(test);
        
        
        
    }
    
/*    
//JPA EXAMPLE
    public void connectionCheck(){
        DataManagerImpl dm = new DataManagerImpl();
        //methods called from a DataManagerImpl object return objects of the respective type
        for(Customer c : dm.AllCustomers()){
           String cust1 = "" + c.getForename() + " " + c.getSurname() + "\n"; 
           System.out.println(cust1);
        }
    }
*/
    
}
