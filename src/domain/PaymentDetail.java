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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
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
    , @NamedQuery(name = "PaymentDetail.findByVersion", query = "SELECT p FROM PaymentDetail p WHERE p.version = :version")})
public class PaymentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payment_detailID")
    private String paymentDetailID;
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
    @Version
    @Column(name = "version")
    private long version;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne(optional = false)
    private OrderTable orderID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "payment_detailID")
    private JobLine jobLine;

    public PaymentDetail() {
    }

    public PaymentDetail(String paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
    }

    public PaymentDetail(String paymentDetailID, long version) {
        this.paymentDetailID = paymentDetailID;
        this.version = version;
    }

    public String getPaymentdetailID() {
        return paymentDetailID;
    }

    public void setPaymentdetailID(String paymentDetailID) {
        this.paymentDetailID = paymentDetailID;
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

    public OrderTable getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTable orderID) {
        this.orderID = orderID;
    }

    /*
    public Collection<PaymentDetail> getPaymentDetailCollection() {
        return paymentDetailCollection;
    }

    public void setPaymentDetailCollection(Collection<PaymentDetail> paymentDetailCollection) {
        this.paymentDetailCollection = paymentDetailCollection;
    }
*/
    

    @XmlTransient
    public JobLine getJobLine() {
        return jobLine;
    }

    public void setJobLine(JobLine jobLine) {
        this.jobLine = jobLine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentDetailID != null ? paymentDetailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.paymentDetailID == null && other.paymentDetailID != null) || (this.paymentDetailID != null && !this.paymentDetailID.equals(other.paymentDetailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PaymentDetail[ paymentdetailID=" + paymentDetailID + " ]";
    }
    
}
