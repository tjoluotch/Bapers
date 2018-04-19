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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author tjay
 */
@Entity
@Table(name = "order_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTable.findAll", query = "SELECT o FROM OrderTable o")
    , @NamedQuery(name = "OrderTable.findByOrderID", query = "SELECT o FROM OrderTable o WHERE o.orderID = :orderID")
    , @NamedQuery(name = "OrderTable.findByTotalPrice", query = "SELECT o FROM OrderTable o WHERE o.totalPrice = :totalPrice")
    , @NamedQuery(name = "OrderTable.findByPaymentStatus", query = "SELECT o FROM OrderTable o WHERE o.paymentStatus = :paymentStatus")
    , @NamedQuery(name = "OrderTable.findByDateSubmitted", query = "SELECT o FROM OrderTable o WHERE o.dateSubmitted = :dateSubmitted")
    , @NamedQuery(name = "OrderTable.findByVersion", query = "SELECT o FROM OrderTable o WHERE o.version = :version")})
public class OrderTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderID")
    private Integer orderID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_price")
    private Float totalPrice;
    @Size(max = 20)
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "date_submitted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSubmitted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<Alert> alertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private Collection<JobLine> jobLineCollection;
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    @ManyToOne
    private Customer accountNo;

    public OrderTable() {
    }

    public OrderTable(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderTable(Integer orderID, long version) {
        this.orderID = orderID;
        this.version = version;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<Alert> getAlertCollection() {
        return alertCollection;
    }

    public void setAlertCollection(Collection<Alert> alertCollection) {
        this.alertCollection = alertCollection;
    }

    @XmlTransient
    public Collection<JobLine> getJobLineCollection() {
        return jobLineCollection;
    }

    public void setJobLineCollection(Collection<JobLine> jobLineCollection) {
        this.jobLineCollection = jobLineCollection;
    }

    public Customer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Customer accountNo) {
        this.accountNo = accountNo;
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
        if (!(object instanceof OrderTable)) {
            return false;
        }
        OrderTable other = (OrderTable) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.OrderTable[ orderID=" + orderID + " ]";
    }
    
}
