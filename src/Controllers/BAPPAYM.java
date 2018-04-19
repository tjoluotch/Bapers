/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.Customer;
import domain.DiscountPlan;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import domain.TaskLine;
import gui.LetterGeneration;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
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
    
    
    public BAPPAYM(){
        dm = new DataManagerImpl();
    }
    
   
    
    public BAPPAYM(JFrame frame){
        this.frame = frame;
        DataManagerImpl dm = new DataManagerImpl();
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
        
        public void firstLetterGeneration(String name, String address, String city1, String postcode1, String date, String orderID, String jobID, String amountDue, String dayOrderWasRecorded) throws IOException {
        //HardCoded
        //String name = "David Rhind";
        //String address = "Northampton Square";
        //String city1 = "London";
        //String postcode1 = "EC1V 0HB";
        
        
        String filename =  name + new Date(System.currentTimeMillis()).toString()+ "LatePaymLetter1.pdf";
        
        
        
        
        //String date= "18th February 2018";
        
        String greet = "Dear " + name;
        
        //String orderID = "1111";
        
        //String jobID = "4555";
        
        //String amountDue = "456.78";
        
        String reminder = "REMINDER-INVOICE NO: " + orderID;
        
        String jobIDWithAmount = "Job No: " + jobID + "      " + "Total Amount: " + amountDue;
        
        //Lab Details
        String labLogo = "The Lab";
        String labName = "Bloomsbury’s Image Processing Laboratory";
        String labAddress = "2, Wynyatt Street, London, EC1V 7HU";
        String labPhone = "Phone: 0207 235 7534";
        
        List<String> customerLines = new ArrayList<>();
        customerLines.add(name);
        customerLines.add(address);
        customerLines.add(city1);
        customerLines.add(postcode1);
        
        
        List<String> labLines = new ArrayList<>();
        labLines.add(labLogo);
        labLines.add(labName);
        labLines.add(labAddress);
        labLines.add(labPhone);
        
        PDDocument doc = null;
try
{
    doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
    
    
    PDFont pdfFont = PDType1Font.HELVETICA;
    float fontSize = 14;
    float leading = 1.5f * fontSize;

    PDRectangle mediabox = page.getMediaBox();
    
    float actualWidth = mediabox.getWidth();
    float actualHeight = mediabox.getHeight();
    
    float margin = 72;
    float width = mediabox.getWidth() - 2*margin;
    float startX = mediabox.getLowerLeftX() + margin;
    float startY = mediabox.getUpperRightY() - margin;

    contentStream.beginText();
    contentStream.setFont(pdfFont, 12);
    contentStream.newLineAtOffset(startX, startY);
    for (String line: customerLines)
    {
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
    }
      
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
    contentStream.newLineAtOffset(220, 85);
    
    for(String line: labLines){
      
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
        contentStream.setFont(pdfFont, 12);
    }
    
    contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    contentStream.newLineAtOffset(-230, -50);
    contentStream.showText(date);
    
    contentStream.newLineAtOffset(0, -30);
    contentStream.showText(greet);
    
    //reminder order no...
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    contentStream.newLineAtOffset(150, -30);
    contentStream.showText(reminder);
    
    contentStream.newLineAtOffset(-18, -leading);
    contentStream.showText(jobIDWithAmount);
    
    String paragraphL1 = "According to our records, it appears that we have not yet received payment of the above";
    
    
    contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    contentStream.newLineAtOffset(-170, -2*leading);
    contentStream.showText(paragraphL1);
    
    //String dayOrderWasRecorded = "18th December 2017";
    String paragraphL2 = "invoice, which was posted to you on " + dayOrderWasRecorded + ", for photographic work done in";
    
    contentStream.newLineAtOffset(0, -leading);
    contentStream.showText(paragraphL2);
    
    String paragraphL3 = " our laboratory.";
    contentStream.newLineAtOffset(0, -leading);
    contentStream.showText(paragraphL3);
    
    String paragraphL4 = "We would appreciate payment at your earliest convenience.";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL4);
    
    String paragraphL5 = "If you have already sent a payment to us recently, please accept our apologies.";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL5);
    
    String paragraphL6 = "Yours sincerely,";
    contentStream.newLineAtOffset(170, -2*leading);
    contentStream.showText(paragraphL6);
    
    String paragraphL7 = "G. Lancaster";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL7);
    
    contentStream.endText(); 
    contentStream.close();

    doc.save(filename);
}
finally
{
    if (doc != null)
    {
        doc.close();
    }
}
    }
    
     public void secondLetterGeneration(String name, String address, String city1, String postcode1, String date, String orderID, String jobID, String amountDue, String dayOrderWasRecorded) throws IOException{
        //HardCoded
        //String  name = "David Rhind";
        //String address = "Northampton Square";
        //String city1 = "London";
        //String postcode1 = "EC1V 0HB";
        
        
        String filename =  name + new Date(System.currentTimeMillis()).toString()+ "LatePaymLetter2.pdf";
        
        
        
        
         //String date= "18th February 2018";
        
        String greet = "Dear " + name;
        
         //String orderID = "1111";
        
         //String jobID = "4555";
        
         //String amountDue = "456.78";
        
        String reminder = "FINAL REMINDER-INVOICE NO: " + orderID;
        
        String jobIDWithAmount = "Job No: " + jobID + "      " + "Total Amount: " + amountDue;
        
        //Lab Details
        String labLogo = "The Lab";
        String labName = "Bloomsbury’s Image Processing Laboratory";
        String labAddress = "2, Wynyatt Street, London, EC1V 7HU";
        String labPhone = "Phone: 0207 235 7534";
        
        List<String> customerLines = new ArrayList<>();
        customerLines.add(name);
        customerLines.add(address);
        customerLines.add(city1);
        customerLines.add(postcode1);
        
        
        List<String> labLines = new ArrayList<>();
        labLines.add(labLogo);
        labLines.add(labName);
        labLines.add(labAddress);
        labLines.add(labPhone);
        
        PDDocument doc = null;
try
{
    doc = new PDDocument();
    PDPage page = new PDPage();
    doc.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(doc, page);
    
    
    PDFont pdfFont = PDType1Font.HELVETICA;
    float fontSize = 14;
    float leading = 1.5f * fontSize;

    PDRectangle mediabox = page.getMediaBox();
    
    float actualWidth = mediabox.getWidth();
    float actualHeight = mediabox.getHeight();
    
    float margin = 72;
    float width = mediabox.getWidth() - 2*margin;
    float startX = mediabox.getLowerLeftX() + margin;
    float startY = mediabox.getUpperRightY() - margin;

    contentStream.beginText();
    contentStream.setFont(pdfFont, 12);
    contentStream.newLineAtOffset(startX, startY);
    for (String line: customerLines)
    {
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
    }
      
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
    contentStream.newLineAtOffset(220, 85);
    
    for(String line: labLines){
      
        contentStream.showText(line);
        contentStream.newLineAtOffset(0, -leading);
        contentStream.setFont(pdfFont, 12);
    }
    
    contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    contentStream.newLineAtOffset(-230, -50);
    contentStream.showText(date);
    
    contentStream.newLineAtOffset(0, -30);
    contentStream.showText(greet);
    
    //reminder order no...
    contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
    contentStream.newLineAtOffset(150, -30);
    contentStream.showText(reminder);
    
    contentStream.newLineAtOffset(-18, -leading);
    contentStream.showText(jobIDWithAmount);
    
    String paragraphL1 = "It appears that we have not received payment of the above invoice, which was posted to";
    
    
    contentStream.setFont(PDType1Font.HELVETICA, fontSize);
    contentStream.newLineAtOffset(-170, -2*leading);
    contentStream.showText(paragraphL1);
    
     //String dayOrderWasRecorded = "18th December 2017";
    String paragraphL2 = "you on " + dayOrderWasRecorded + ", for photographic work done in our laboratory, despite a";
    
    contentStream.newLineAtOffset(0, -leading);
    contentStream.showText(paragraphL2);
    
    String paragraphL3 = "reminder letter posted to you 1 month later.";
    contentStream.newLineAtOffset(0, -leading);
    contentStream.showText(paragraphL3);
    
    String paragraphL4 = "Unless you pay the outstanding amount in full within SEVEN DAYS, or contact us with";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL4);
    
    String paragraphL5 = "proposals for repayment, we will have no option but to refer the matter to our solicitor.";
    contentStream.newLineAtOffset(0, -leading);
    contentStream.showText(paragraphL5);
    
    String paragraphL6 = "Please send payment immediately to avoid further action.";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL6);
    
    String paragraphL7 = "Yours sincerely,";
    contentStream.newLineAtOffset(170, -2*leading);
    contentStream.showText(paragraphL7);
    
    String paragraphL8 = "G. Lancaster";
    contentStream.newLineAtOffset(0, -2*leading);
    contentStream.showText(paragraphL8);
    
    contentStream.endText(); 
    contentStream.close();

    doc.save(filename);
}
finally
{
    if (doc != null)
    {
        doc.close();
    }
}
    }
    
    // if true then affect the GUI
    public boolean officeManagerIsLoggedIn(int logCode){
            boolean popupForLetter = false;
            //if office manager is logged in
            if(logCode == 1){
                 // display the showOptionDialog
            int choice = JOptionPane.showOptionDialog(null, 
             "Click Yes to advance", 
               "View Late pay reminder letters", 
              JOptionPane.YES_NO_OPTION, 
              JOptionPane.QUESTION_MESSAGE, 
               null, null, null);
            
            // if user selects yes open letter generation
            if (choice == JOptionPane.YES_OPTION){
                LetterGeneration lg = new LetterGeneration();
                lg.setVisible(true);
                }
            } else {
               return popupForLetter;
            }
            return popupForLetter;
    }
    
            public List<OrderTable> unpaidOrders(){
           
            List <OrderTable> resultList= dm.allOrdersUnpaidTablesforCustomer();
            OrderTable current;
            for (Iterator<OrderTable> it = resultList.iterator(); it.hasNext();) {
            current = it.next();
            current.getAccountNo();
            System.out.println(current);
         }   
         
            return resultList;
    }
            
            public void checkCompletionDate() throws IOException{
                Date highestDate = new Date(0);
                Customer cust;
                Date presentDay = new Date();
                List<OrderTable> checkList = this.unpaidOrders();
                     for (OrderTable current : checkList) {
                    Collection<JobLine> allJobsInTheOrder = current.getJobLineCollection();
                        for (JobLine job : allJobsInTheOrder){
                            Collection <TaskLine> tasks = job.getTaskLineCollection();
                            for(TaskLine task : tasks){
                                
                                if(task.getEndTime().after(highestDate)){
                                          highestDate  = task.getEndTime();
                                          
                                    LocalDate ld = highestDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    int test_month = ld.getMonthValue();
                                    LocalDate currentDate = presentDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    int current_month = currentDate.getMonthValue();
                                    int currentDay = currentDate.getDayOfMonth();
                                    if (current_month - test_month >= 1) {
                                        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d yyyy"); 
                                        
                                        String highestDateFormatted = formatter.format(highestDate);
                                        String presentDateFormatted = formatter.format(presentDay);
                                        
                                      String pk =  current.getAccountNo().getAccountNo();
                                       cust = dm.getEm().find(Customer.class, pk);
                                       
                                        System.out.println(cust);
                                       String fullname = cust.getForename() + " " + cust.getSurname();
                                        System.out.println(fullname);
                                       this.firstLetterGeneration(fullname, cust.getAddress1(), cust.getCity(), 
                                                                    cust.getPostcode(), presentDateFormatted, current.getOrderID().toString(), job.getJoblineID().toString(), 
                                                                        current.getTotalPrice().toString(),highestDateFormatted);
                                       
                                       JobLine jl = dm.getEm().find(JobLine.class, job.getJoblineID());
                                        
                                       dm.getEm().getTransaction().begin();
                                       jl.setReminderStatus("first");
                                        dm.getEm().getTransaction().commit();
                                    }
                                }
                                 
                                
                            }
                        }
                     }
                
            }
            
              public void checkCompletionDateWithPrint2() throws IOException{
                Date highestDate = new Date(0);
                Customer cust;
                Date presentDay = new Date();
                List<OrderTable> checkList = this.unpaidOrders();
                     for (OrderTable current : checkList) {
                    Collection<JobLine> allJobsInTheOrder = current.getJobLineCollection();
                        for (JobLine job : allJobsInTheOrder){
                            Collection <TaskLine> tasks = job.getTaskLineCollection();
                            for(TaskLine task : tasks){
                                
                                if(task.getEndTime().after(highestDate)){
                                          highestDate  = task.getEndTime();
                                          
                                    LocalDate ld = highestDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    int test_month = ld.getMonthValue();
                                    LocalDate currentDate = presentDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                    int current_month = currentDate.getMonthValue();
                                    int currentDay = currentDate.getDayOfMonth();
                                    if (current_month - test_month >= 2) {
                                        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d yyyy"); 
                                        
                                        String highestDateFormatted = formatter.format(highestDate);
                                        String presentDateFormatted = formatter.format(presentDay);
                                        
                                      String pk =  current.getAccountNo().getAccountNo();
                                       cust = dm.getEm().find(Customer.class, pk);
                                       
                                        dm.getEm().getTransaction().begin();
                                        cust.setStatus("suspended");
                                        dm.getEm().getTransaction().commit();
                                       
                                        System.out.println(cust);
                                       String fullname = cust.getForename() + " " + cust.getSurname();
                                        System.out.println(fullname);
                                       this.secondLetterGeneration(fullname, cust.getAddress1(), cust.getCity(), 
                                                                    cust.getPostcode(), presentDateFormatted, current.getOrderID().toString(), job.getJoblineID().toString(), 
                                                                        current.getTotalPrice().toString(),highestDateFormatted);
                                       
                                       JobLine jl = dm.getEm().find(JobLine.class, job.getJoblineID());
                                        
                                       dm.getEm().getTransaction().begin();
                                       jl.setReminderStatus("Second");
                                        dm.getEm().getTransaction().commit();
                                    }
                                }
                                 
                                
                            }
                        }
                     }
                
        
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
	
}

