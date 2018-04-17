/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "payment_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetail.findAll", query = "SELECT p FROM PaymentDetail p")
    , @NamedQuery(name = "PaymentDetail.findByPaymentdetailID", query = "SELECT p FROM PaymentDetail p WHERE p.paymentdetailID = :paymentdetailID")
    , @NamedQuery(name = "PaymentDetail.findByExpiryDate", query = "SELECT p FROM PaymentDetail p WHERE p.expiryDate = :expiryDate")
    , @NamedQuery(name = "PaymentDetail.findByType", query = "SELECT p FROM PaymentDetail p WHERE p.type = :type")
    , @NamedQuery(name = "PaymentDetail.findByLast4digits", query = "SELECT p FROM PaymentDetail p WHERE p.last4digits = :last4digits")
    , @NamedQuery(name = "PaymentDetail.findByVersion", query = "SELECT p FROM PaymentDetail p WHERE p.version = :version")
    , @NamedQuery(name = "PaymentDetail.findByAmount", query = "SELECT p FROM PaymentDetail p WHERE p.amount = :amount")})
public class PaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "payment_detailID")
    private Integer paymentdetailID;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Size(max = 10)
    @Column(name = "type")
    private String type;
    @Size(max = 4)
    @Column(name = "last4digits")
    private String last4digits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Float amount;
    @OneToMany(mappedBy = "paymentdetailID")
    private Collection<JobLine> jobLineCollection;

    public PaymentDetail() {
    }

    public PaymentDetail(Integer paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    public PaymentDetail(Integer paymentdetailID, long version) {
        this.paymentdetailID = paymentdetailID;
        this.version = version;
    }

    public Integer getPaymentdetailID() {
        return paymentdetailID;
    }

    public void setPaymentdetailID(Integer paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLast4digits() {
        return last4digits;
    }

    public void setLast4digits(String last4digits) {
        this.last4digits = last4digits;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @XmlTransient
    public Collection<JobLine> getJobLineCollection() {
        return jobLineCollection;
    }

    public void setJobLineCollection(Collection<JobLine> jobLineCollection) {
        this.jobLineCollection = jobLineCollection;
    }
    
     public void addJobLine(JobLine jobLine){
        jobLineCollection.add(jobLine);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentdetailID != null ? paymentdetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.paymentdetailID == null && other.paymentdetailID != null) || (this.paymentdetailID != null && !this.paymentdetailID.equals(other.paymentdetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PaymentDetail[ paymentdetailID=" + paymentdetailID + " ]";
    }
    
}
