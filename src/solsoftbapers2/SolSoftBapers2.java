/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solsoftbapers2;

import Controllers.*;
import data.*;
import domain.Customer;
import gui.*;
import java.awt.Panel;

import java.io.IOException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.pdfbox.pdmodel.PDDocument;
import Controllers.*;
import data.*;
import domain.*;
import java.util.Date;




public class SolSoftBapers2 {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    
    public static void main(String[] args) throws IOException {
        
       
        
       //GUI's 
        //Login loginPage = new Login();
        //loginPage.setVisible(true);
        BAPPAYM p = new BAPPAYM();
        p.checkCompletionDate();
      
       
         
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
