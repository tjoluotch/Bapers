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
import java.util.regex.*;
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
    public float getDiscountedPrice(Collection<JobLine> jobs, Collection<DiscountPlan> discounts){
        float price = 0;
        Collection<DiscountPlan> flexibleDiscounts = new ArrayList();
        if(discounts.isEmpty()){ price = getNormalPrice(jobs); } 
        else {
            for(JobLine job : jobs){
                for(DiscountPlan discount : discounts){
                    //Variable
                    if(discount.getTaskID() != null){
                        for(TaskLine task : job.getTaskLineCollection()){
                            if(discount.getTaskID() == task.getTaskID()){
                                price += task.getPrice()*discount.getRate();
                            }
                        }
                    //Fixed
                    } else if (discount.getFlexibleRate() == null && discount.getTaskID() == null) {
                        price += (job.getJobCode().getPrice()) * discount.getRate();
                    } else 
                    //Flexible
                    if (discount.getFlexibleRate() != null){
                        //adds the DiscountsTable with flexible discounts
                        flexibleDiscounts.add(discount);
                    }
                }
            }
            if(!flexibleDiscounts.isEmpty() && flexibleDiscounts.size() == 1){
                String flexibleDiscountString = flexibleDiscounts.iterator().next().getFlexibleRate();
                Pattern flexiblePattern = Pattern.compile(flexibleDiscountString);
                //regular expression stuff here
            } else if (flexibleDiscounts.size() > 1) { 
                System.out.println("Customer has " + flexibleDiscounts.size() + " variable discounts!"); }
        }
        return price;
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
    
    
    
    public void firstLetterGeneration(String forename, String surname, String accountHolderName, String address1, String city, String postcode, String telephone, String dateSubmitted) throws IOException{
        String filename = "/Users/tjay/NetBeansProjects/" + /*c.getAccountHolderName()*/"DavidRhind" + "LatePaymLetter1.pdf";
        
        String name = forename + " " + surname;
        String accountHolder = accountHolderName;
        String address = address1 + ", " + city + ", " + postcode;
        String phoneNumber = "Phone: " + telephone;
        
        String wording = "According to our records, it appears that we have not yet received payment of the order you made on the , which was posted"; 
        String wording2 = "to you on" + dateSubmitted + ", for photographic work done in our laboratory.";
        String wording3 = "We would appreciate payment at your earliest convenience.";
        String wording4 = "If you have already sent a payment to us recently, please accept our apologies.";
        String wording5 = "Yours sincerely,";
        String wording6 = "G. Lancaster";
        
        PDDocument doc = new PDDocument();
        try {
            PDPage page = new PDPage();
            doc.addPage(page);
            
            PDFont LabNamefont = PDType1Font.HELVETICA_BOLD;
            PDFont StandardFont = PDType1Font.HELVETICA;
            PDPageContentStream contents = new PDPageContentStream(doc, page);
            contents.beginText();
            contents.setFont(LabNamefont, 30);
            contents.newLineAtOffset(300, 700);
            contents.showText(name);
            
            
            
            contents.setFont(StandardFont, 15);
            contents.newLineAtOffset(300, 680);
            contents.showText(name);
            
            contents.newLine();
            contents.showText(address);
            
            contents.newLine();
            contents.showText(phoneNumber);
            
            
            
            
            
            contents.newLineAtOffset(100, 610);
            contents.showText(wording);
            contents.newLine();
            contents.showText(wording2);
            contents.newLine();
            contents.showText(wording3);
            contents.newLine();
            contents.showText(wording4);
            contents.newLine();
            contents.showText(wording5);
            contents.newLine();
            contents.showText(wording6);
            
           
                    
            contents.endText();
            contents.close();
           
            doc.save(filename);
        } finally {
            doc.close();
        }
    }
	
}

