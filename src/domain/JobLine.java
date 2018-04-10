/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanTe
 */
//SELECT * FROM Products
//WHERE Price BETWEEN 10 AND 20
@Entity
@Table(name = "job_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobLine.findAll", query = "SELECT j FROM JobLine j")
    , @NamedQuery(name = "JobLine.findByJoblineID", query = "SELECT j FROM JobLine j WHERE j.joblineID = :joblineID")
    , @NamedQuery(name = "JobLine.findByDate", query = "SELECT j FROM JobLine j WHERE j.date = :date")
    
    , @NamedQuery(name = "JobLine.findByStartTime", query = "SELECT j FROM JobLine j WHERE j.startTime = :startTime")
    , @NamedQuery(name = "JobLine.findByEndTime", query = "SELECT j FROM JobLine j WHERE j.endTime = :endTime")})
public class JobLine implements Serializable {

     @Id
    @Basic(optional = false)
    @Column(name = "Job_lineID")
    private Integer joblineID;
    @Temporal(TemporalType.DATE)
    private Date jobDeadline;
    @Size(max = 100)
    @Column(name = "special instructions")
    private String specialInstructions;
    @Size(max = 20)
    @Column(name = "reminder_status")
    private String reminderStatus;
    @JoinColumn(name = "job_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Job jobCode;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne(optional = false)
    private OrderTable orderID;
    @JoinColumn(name = "payment_detailID", referencedColumnName = "payment_detailID")
    @ManyToOne(optional = false)
    private PaymentDetail paymentdetailID;

    private static final long serialVersionUID = 1L;
    
    

    public JobLine() {
    }

    public JobLine(Integer joblineID) {
        this.joblineID = joblineID;
    }

    public Integer getJoblineID() {
        return joblineID;
    }

    public void setJoblineID(Integer joblineID) {
        this.joblineID = joblineID;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (joblineID != null ? joblineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobLine)) {
            return false;
        }
        JobLine other = (JobLine) object;
        if ((this.joblineID == null && other.joblineID != null) || (this.joblineID != null && !this.joblineID.equals(other.joblineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.JobLine[ joblineID=" + joblineID + " ]";
    }

    

    public Date getJobDeadline() {
        return jobDeadline;
    }

    public void setJobDeadline(Date jobDeadline) {
        this.jobDeadline = jobDeadline;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public String getReminderStatus() {
        return reminderStatus;
    }

    public void setReminderStatus(String reminderStatus) {
        this.reminderStatus = reminderStatus;
    }

    public Job getJobCode() {
        return jobCode;
    }

    public void setJobCode(Job jobCode) {
        this.jobCode = jobCode;
    }

    public OrderTable getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTable orderID) {
        this.orderID = orderID;
    }

    public PaymentDetail getPaymentdetailID() {
        return paymentdetailID;
    }

    public void setPaymentdetailID(PaymentDetail paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }
    
}
