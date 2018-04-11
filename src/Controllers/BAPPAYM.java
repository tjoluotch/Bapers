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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
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
  
    //card payments
    //for whole order
    public void createPayment(OrderTable order, String last4, Date expiryDate){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
        payment.setOrderID(order);
        payment.setJobLineCollection(order.getJobLineCollection());
    }
    
    //for one job
    public void createPayment(JobLine job, String last4, Date expiryDate){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("Card");
        payment.setExpiryDate(expiryDate);
        payment.setLast4digits(last4);
        payment.addJobLine(job);
        payment.setOrderID(job.getOrderID());
    }
    
    
    //cash payments
    //for whole order
    public void createPayment(OrderTable order){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("cash");
        payment.setExpiryDate(null);
        payment.setLast4digits(null);
        payment.setOrderID(order);
        payment.setJobLineCollection(order.getJobLineCollection());
    }
    //for one job
    public void createPayment(JobLine job){
        PaymentDetail payment = new PaymentDetail();
        payment.setType("cash");
        payment.setExpiryDate(null);
        payment.setLast4digits(null);
        payment.setOrderID(job.getOrderID());
        payment.addJobLine(job);
    }
}
