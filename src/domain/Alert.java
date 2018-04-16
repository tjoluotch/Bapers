/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "alert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a")
    , @NamedQuery(name = "Alert.findByAlertID", query = "SELECT a FROM Alert a WHERE a.alertID = :alertID")
    , @NamedQuery(name = "Alert.findByDescription", query = "SELECT a FROM Alert a WHERE a.description = :description")
    , @NamedQuery(name = "Alert.findByTarget", query = "SELECT a FROM Alert a WHERE a.target = :target")})
public class Alert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "alertID")
    private Integer alertID;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "target")
    private String target;
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    @ManyToOne(optional = false)
    private Customer accountNo;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne(optional = false)
    private OrderTable orderID;

    public Alert() {
    }

    public Alert(Integer alertID) {
        this.alertID = alertID;
    }

    public Integer getAlertID() {
        return alertID;
    }

    public void setAlertID(Integer alertID) {
        this.alertID = alertID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Customer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Customer accountNo) {
        this.accountNo = accountNo;
    }

    public OrderTable getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTable orderID) {
        this.orderID = orderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertID != null ? alertID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alert)) {
            return false;
        }
        Alert other = (Alert) object;
        if ((this.alertID == null && other.alertID != null) || (this.alertID != null && !this.alertID.equals(other.alertID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Alert[ alertID=" + alertID + " ]";
    }
    
}