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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "job_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobLine.findAll", query = "SELECT j FROM JobLine j")
    , @NamedQuery(name = "JobLine.findByJoblineID", query = "SELECT j FROM JobLine j WHERE j.joblineID = :joblineID")
    , @NamedQuery(name = "JobLine.findByJobDeadline", query = "SELECT j FROM JobLine j WHERE j.jobDeadline = :jobDeadline")
    , @NamedQuery(name = "JobLine.findBySpecialInstructions", query = "SELECT j FROM JobLine j WHERE j.specialInstructions = :specialInstructions")
    , @NamedQuery(name = "JobLine.findByReminderStatus", query = "SELECT j FROM JobLine j WHERE j.reminderStatus = :reminderStatus")
    , @NamedQuery(name = "JobLine.findByVersion", query = "SELECT j FROM JobLine j WHERE j.version = :version")})
public class JobLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "job_lineID")
    private Integer joblineID;
    @Column(name = "job_deadline")
    @Temporal(TemporalType.DATE)
    private Date jobDeadline;
    @Size(max = 100)
    @Column(name = "special_instructions")
    private String specialInstructions;
    @Size(max = 20)
    @Column(name = "reminder_status")
    private String reminderStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @JoinColumn(name = "job_code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Job jobCode;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne(optional = false)
    private OrderTable orderID;
    @JoinColumn(name = "payment_detailID", referencedColumnName = "payment_detailID")
    @ManyToOne(optional = false)
    private PaymentDetail paymentdetailID;

    public JobLine() {
    }

    public JobLine(Integer joblineID) {
        this.joblineID = joblineID;
    }

    public JobLine(Integer joblineID, long version) {
        this.joblineID = joblineID;
        this.version = version;
    }

    public Integer getJoblineID() {
        return joblineID;
    }

    public void setJoblineID(Integer joblineID) {
        this.joblineID = joblineID;
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
    
}
