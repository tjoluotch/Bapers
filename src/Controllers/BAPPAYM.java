/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import data.DataManagerImpl;
import domain.JobLine;
import domain.OrderTable;
import domain.PaymentDetail;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

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
    }
    
    //for jobs
    public void createPayment(List<JobLine> jobs, String last4, String expiryDate){ //NEED TO UPDATE EXPIRY DATE
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(java.sql.Date.valueOf(expiryDate));
        payment.setLast4digits(last4);
        OrderTable orderID = null;
        for(JobLine job : jobs){
            payment.addJobLine(job);
            job.setPaymentdetailID(payment);
            orderID = job.getOrderID();
        }
        payment.setOrderID(orderID);
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
    }
}

