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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
 * @author DanTe
 */
@Entity
@Table(name = "payment_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetail.findAll", query = "SELECT p FROM PaymentDetail p")
    , @NamedQuery(name = "PaymentDetail.findByOrderID", query = "SELECT p FROM PaymentDetail p WHERE p.orderID = :orderID")
    , @NamedQuery(name = "PaymentDetail.findByExpiryDate", query = "SELECT p FROM PaymentDetail p WHERE p.expiryDate = :expiryDate")
    , @NamedQuery(name = "PaymentDetail.findByType", query = "SELECT p FROM PaymentDetail p WHERE p.type = :type")
    , @NamedQuery(name = "PaymentDetail.findByLast4digits", query = "SELECT p FROM PaymentDetail p WHERE p.last4digits = :last4digits")})
public class PaymentDetail implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "payment_detailID", nullable = false, length = 45)
    private String paymentdetailID;
    @Basic(optional = false)
    @NotNull
    @Version
    @Column(name = "version", nullable = false)
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentdetailID")
    private Collection<JobLine> jobLineCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderID")
    private Integer orderID;
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Column(name = "type")
    private String type;
    @Column(name = "last4digits")
    private String last4digits;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private OrderTable orderTable;

    public PaymentDetail() {
    }

    public PaymentDetail(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
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

    public OrderTable getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(OrderTable orderTable) {
        this.orderTable = orderTable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetail)) {
            return false;
        }
        PaymentDetail other = (PaymentDetail) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PaymentDetail[ orderID=" + orderID + " ]";
    }

    public PaymentDetail(String paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    public PaymentDetail(String paymentdetailID, long version) {
        this.paymentdetailID = paymentdetailID;
        this.version = version;
    }

    public String getPaymentdetailID() {
        return paymentdetailID;
    }

    public void setPaymentdetailID(String paymentdetailID) {
        this.paymentdetailID = paymentdetailID;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<JobLine> getJobLineCollection() {
        return jobLineCollection;
    }

    public void setJobLineCollection(Collection<JobLine> jobLineCollection) {
        this.jobLineCollection = jobLineCollection;
    }

   

    
    
}
