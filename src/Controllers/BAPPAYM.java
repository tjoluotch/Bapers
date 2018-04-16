/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.DicountPlan;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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
    //for whole order
    public void createPayment(OrderTable order, String last4, Date expiryDate){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
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
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    }
    
    //for jobs
    public void createPayment(List<JobLine> jobs, String last4, Date expiryDate){ //NEED TO UPDATE EXPIRY DATE
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        //payment.setExpiryDate(java.sql.Date.valueOf(expiryDate));
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
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
     
         //after discount calculated
        float pd = calculateDiscount(payment,d);
        payment.setAmount(pd);
        dm.savePayment(payment);
    }
    //calculate discount for saving payment
    public float calculateDiscount(PaymentDetail p, DicountPlan d){
        float subTotal = p.getAmount();
        float percentage = d.getRate() * subTotal;
        float lastAmount = subTotal - percentage;
        
        return lastAmount;
    }
    
    public void LetterGeneration() throws IOException{
        String filename = "/Users/tjay/NetBeansProjects/" + /*c.getAccountHolderName()*/"DavidRhind" + "LatePaym.pdf";
        String theLab = "The Lab";
        String LabName = "Bloombsbury's Image Processing Laboratory";
        String LabAdress = "2 Wynyatt Street, London, EC1V 7HU";
        String LabNumber = "Phone: 0207 235 7534";
        
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
            contents.showText(theLab);
            contents.endText();
            
            contents.beginText();
            contents.setFont(StandardFont, 15);
            contents.newLineAtOffset(300, 680);
            contents.showText(LabName);
            contents.endText();
            
            contents.beginText();
            contents.newLineAtOffset(300, 660);
            contents.showText(LabAdress);
            contents.endText();
            
            contents.beginText();
            contents.newLineAtOffset(300, 640);
            contents.showText(LabNumber);
            
           
                    
            contents.endText();
            contents.close();
           
            doc.save(filename);
        } finally {
            doc.close();
        }
    }
}
