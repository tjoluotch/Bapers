/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
<<<<<<< HEAD
import domain.Customer;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.DicountPlan;
=======
import domain.DiscountPlan;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
>>>>>>> Sylvester'
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
<<<<<<< HEAD


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
=======
import javax.swing.JOptionPane;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.jbig2.util.log.LoggerFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
>>>>>>> Sylvester'
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
    //for whole order
    public void createPayment(OrderTable order, String last4, Date expiryDate){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
<<<<<<< HEAD
        payment.setOrderID(order);
        payment.setJobLineCollection(order.getJobLineCollection());
        order.addPaymentDetail(payment);
        for(JobLine job : order.getJobLineCollection()){
            job.setPaymentdetailID(payment);
        }
        dm.savePayment(payment);
        
         //calculating discounted total
        DicountPlan d = new DicountPlan();
     
         //after discount calculated
=======
        
        payment.setJobLineCollection(order.getJobLineCollection());
        //order.addPaymentDetail(payment);
        for(JobLine job : order.getJobLineCollection()){
            
            job.setPaymentdetailID(payment);
        }
        
        
         //calculating discounted total
        
     
         //after discount calculated
         DiscountPlan d = new DiscountPlan();
>>>>>>> Sylvester'
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    }
    
<<<<<<< HEAD
    //for jobs
    public void createPayment(List<JobLine> jobs, String last4, Date expiryDate){ //NEED TO UPDATE EXPIRY DATE
=======
    
    
    
    //for jobs
     public void createPayment(List<JobLine> jobs, String last4, Date expiryDate){ //NEED TO UPDATE EXPIRY DATE
>>>>>>> Sylvester'
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        //payment.setExpiryDate(java.sql.Date.valueOf(expiryDate));
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
<<<<<<< HEAD
        OrderTable orderID = null;
        for(JobLine job : jobs){
            payment.addJobLine(job);
            job.setPaymentdetailID(payment);
            orderID = job.getOrderID();
        }
        payment.setOrderID(orderID);
        dm.savePayment(payment);
        
         //calculating discounted total
        DicountPlan d = new DicountPlan();
=======
        payment.setJobLineCollection(jobs);
        
        
        for(JobLine job : jobs){
            
            job.setPaymentdetailID(payment);
            
           
        }
        
        
        
         //calculating discounted total
        DiscountPlan d = new DiscountPlan();
>>>>>>> Sylvester'
     
         //after discount calculated
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    } 
    
    //cash payments
    //for whole order
    public void createPayment(OrderTable order){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Cash");
        payment.setExpiryDate(null);
        payment.setLast4digits(null);
<<<<<<< HEAD
        payment.setOrderID(order);
        payment.setJobLineCollection(order.getJobLineCollection());
        order.addPaymentDetail(payment);
        for(JobLine job : order.getJobLineCollection()){
            job.setPaymentdetailID(payment);
        }
        dm.savePayment(payment);
        
        
         //calculating discounted total
        DicountPlan d = new DicountPlan();
=======
        
        payment.setJobLineCollection(order.getJobLineCollection());
        //order.addPaymentDetail(payment);
        for(JobLine job : order.getJobLineCollection()){
            job.setPaymentdetailID(payment);
        }
        
        
        
         //calculating discounted total
        DiscountPlan d = new DiscountPlan();
>>>>>>> Sylvester'
     
         //after discount calculated
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    }
    //for jobs
    public void createPayment(List<JobLine> jobs){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Cash");
        payment.setExpiryDate(null);
        payment.setLast4digits(null);
<<<<<<< HEAD
        OrderTable orderID = null;
        for(JobLine job : jobs){
            payment.addJobLine(job);
            job.setPaymentdetailID(payment);
            orderID = job.getOrderID();
        }
        payment.setOrderID(orderID);
        dm.savePayment(payment);
        
        //calculating discounted total
        DicountPlan d = new DicountPlan();
=======
        
        for(JobLine job : jobs){
            payment.addJobLine(job);
            job.setPaymentdetailID(payment);
            
        }
        
        
        
        //calculating discounted total
        DiscountPlan d = new DiscountPlan();
>>>>>>> Sylvester'
     
         //after discount calculated
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    }
<<<<<<< HEAD
    //calculate discount for saving payment
    public float calculateDiscount(PaymentDetail p, DicountPlan d){
=======
    
     //calculate discount for saving payment
    public float calculateDiscount(PaymentDetail p, DiscountPlan d){
>>>>>>> Sylvester'
        float subTotal = p.getAmount();
        float percentage = d.getRate() * subTotal;
        float lastAmount = subTotal - percentage;
        
        return lastAmount;
    }
    
<<<<<<< HEAD
    public void firstLetterGeneration() throws IOException{
        String filename = "/Users/tjay/NetBeansProjects/" + /*c.getAccountHolderName()*/"DavidRhind" + "LatePaymLetter1.pdf";
        
        String theLab = "The Lab";
        String LabName = "Bloombsbury's Image Processing Laboratory";
        String LabAdress = "2 Wynyatt Street, London, EC1V 7HU";
        String LabNumber = "Phone: 0207 235 7534";
        
        String wording = "According to our records, it appears that we have not yet received payment of the above invoice, which was posted"; 
        String wording2 = "to you on 18th December 2017, for photographic work done in our laboratory.";
=======
    public void firstLetterGeneration(String forename, String surname, String accountHolderName, String address1, String city, String postcode, String telephone, String dateSubmitted) throws IOException{
        String filename = "/Users/tjay/NetBeansProjects/" + /*c.getAccountHolderName()*/"DavidRhind" + "LatePaymLetter1.pdf";
        
        String name = forename + " " + surname;
        String accountHolder = accountHolderName;
        String address = address1 + ", " + city + ", " + postcode;
        String phoneNumber = "Phone: " + telephone;
        
        String wording = "According to our records, it appears that we have not yet received payment of the order you made on the , which was posted"; 
        String wording2 = "to you on" + dateSubmitted + ", for photographic work done in our laboratory.";
>>>>>>> Sylvester'
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
<<<<<<< HEAD
            
            
            contents.beginText();
            contents.setFont(LabNamefont, 30);
            contents.newLineAtOffset(300, 700);
            contents.showText(theLab);
=======
            contents.beginText();
            contents.setFont(LabNamefont, 30);
            contents.newLineAtOffset(300, 700);
            contents.showText(name);
>>>>>>> Sylvester'
            
            
            
            contents.setFont(StandardFont, 15);
            contents.newLineAtOffset(300, 680);
<<<<<<< HEAD
            contents.showText(LabName);
            
            contents.newLine();
            contents.showText(LabAdress);
            
            contents.newLine();
            contents.showText(LabNumber);
=======
            contents.showText(name);
            
            contents.newLine();
            contents.showText(address);
            
            contents.newLine();
            contents.showText(phoneNumber);
>>>>>>> Sylvester'
            
            
            
            
            
            contents.newLineAtOffset(100, 610);
            contents.showText(wording);
<<<<<<< HEAD
=======
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
>>>>>>> Sylvester'
            
           
                    
            contents.endText();
            contents.close();
           
            doc.save(filename);
        } finally {
            doc.close();
        }
    }
<<<<<<< HEAD
=======
	
>>>>>>> Sylvester'
}

