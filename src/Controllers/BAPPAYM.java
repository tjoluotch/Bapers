/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.DiscountPlan;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.TaskLine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Daniel
 */
public class BAPPAYM {
    
    DataManagerImpl dm;
    JFrame frame;
    
    public BAPPAYM(DataManagerImpl dm){
        this.dm = dm;
    }
    
    public BAPPAYM(){
        
    }
    
    public BAPPAYM(DataManagerImpl dm, JFrame frame){
        this.dm = dm;
        this.frame = frame;
    }
    
    //CREATE PAYMENTDETAIL METHODS
    //card payments    
     public void createPayment(Collection<JobLine> jobs, String last4, Date expiryDate, float amount){ //NEED TO UPDATE EXPIRY DATE
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
        payment.setJobLineCollection(jobs);    
        payment.setAmount(amount);
        for(JobLine job : jobs){
            job.setPaymentdetailID(payment);
        }
        dm.savePayment(payment);
    } 
    //cash payments
    public void createPayment(Collection<JobLine> jobs, float amount){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Cash");
        payment.setExpiryDate(null);
        
        payment.setLast4digits(null);
        payment.setJobLineCollection(jobs);
        
        
        payment.setAmount(amount);
        for(JobLine job : jobs){
            job.setPaymentdetailID(payment);   
        }        
        
        
        dm.savePayment(payment);
    }
    
    //calculates actual price of
    //method to calcuate price for VARIABLE (task specific) & fixed discounts FOR LIST OF JOBS
    public float flexibleCalculate(Collection<JobLine> jobs, Collection<DiscountPlan> discounts){
        float price = 0;
        List<DiscountPlan> flexibleDiscounts = new LinkedList(discounts);
        if(discounts.isEmpty()){ price = getNormalPrice(jobs); } 
        
        else{

                DiscountPlan dp = flexibleDiscounts.get(0);
                
                String discountString = dp.getFlexibleRate();
                String rate ;
                
                List<String> allMatches = new ArrayList<String>();
                 Matcher m = Pattern.compile("\\[([^]]+)\\]").matcher(discountString);
                 float x = 0 ;
                while (m.find()) {
                allMatches.add(m.group(1));
                
                rate = m.group(1);
                
                
                
                
                }
                
                for(JobLine j : jobs){
                    x += j.getJobCode().getPrice();
                }
                
                for (String sd : allMatches){
                    
                price += flexCalc(x,sd);
                }
                
                
                        
                
                
                
        }
                
                //regular expression stuff here
             
        
        return price;
    }
    
    
    public float variableCalculate(Collection<JobLine> jobs, Collection<DiscountPlan> discounts){
        float totalPrice = 0;
        for (JobLine j : jobs){
            List<TaskLine> tl = (List<TaskLine>) j.getTaskLineCollection();
            for(TaskLine t : tl){
                for(DiscountPlan d : discounts){
                    if(d.getTaskID() == t.getTaskID()){
                       float b = t.getTaskID().getPrice()*d.getRate();
                       t.setPrice(b);
                       totalPrice+= b;
                        
                    }
                }
            }
        }
        
        return totalPrice;
    }
    
    public float fixedPrice(float total, Collection<DiscountPlan> discounts){
        List<DiscountPlan> fixed = new LinkedList(discounts);
        DiscountPlan d = fixed.get(0);
        float totalRate = total*d.getRate();
        
        return totalRate;
        
    }
    
    //calculates normal price of a list of jobs
    public float getNormalPrice(Collection<JobLine> jobs){
        float price = 0;
        for(JobLine job : jobs){
            price += job.getJobCode().getPrice();
        }
        return price;
    }
    
    //method to calculate the surcharge of a job based on urgency
    public void calculateSurcharge(JobLine job){
        
    }
    
    
  
    
    
    public float flexCalc(float total, String bound){
        
        
        
          List<String> allMatches = new ArrayList<String>();
                ;
                 String ls = bound.substring(0, bound.indexOf(","));
                 String hs = bound.substring(bound.indexOf(",")+1, bound.indexOf("-"));
                 String rs = bound.substring(bound.indexOf("-") + 1);
                 int lower = Integer.parseInt(ls.trim());
                int higher= Integer.parseInt(hs.trim());
                float rate = Float.parseFloat(rs.trim());
                if(total < higher && total > lower ){
                    total = (total - lower) * rate; 
                }
                else if(total > higher && total > lower ){
                    total = (higher - lower) * rate; 
                }
                
                else if(total < lower){
                    
                   return 0;
                }
        
        return total;
        
        
        
    }
    
    
   
	
}

