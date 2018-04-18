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
 * @author redwan
 */
@Entity
@Table(name = "discount_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiscountPlan.findAll", query = "SELECT d FROM DiscountPlan d")
    , @NamedQuery(name = "DiscountPlan.findByDiscountplanID", query = "SELECT d FROM DiscountPlan d WHERE d.discountplanID = :discountplanID")
    , @NamedQuery(name = "DiscountPlan.findByRate", query = "SELECT d FROM DiscountPlan d WHERE d.rate = :rate")
    , @NamedQuery(name = "DiscountPlan.findByFlexibleRate", query = "SELECT d FROM DiscountPlan d WHERE d.flexibleRate = :flexibleRate")})
public class DiscountPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discount_planID")
    private Integer discountplanID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Float rate;
    @Size(max = 45)
    @Column(name = "flexible_rate")
    private String flexibleRate;
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    @ManyToOne(optional = false)
    private Customer accountNo;
    @JoinColumn(name = "taskID", referencedColumnName = "taskID")
    @ManyToOne
    private Task taskID;

    public DiscountPlan() {
    }

    public DiscountPlan(Integer discountplanID) {
        this.discountplanID = discountplanID;
    }

    public Integer getDiscountplanID() {
        return discountplanID;
    }

    public void setDiscountplanID(Integer discountplanID) {
        this.discountplanID = discountplanID;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getFlexibleRate() {
        return flexibleRate;
    }

    public void setFlexibleRate(String flexibleRate) {
        this.flexibleRate = flexibleRate;
    }

    public Customer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Customer accountNo) {
        this.accountNo = accountNo;
    }

    public Task getTaskID() {
        return taskID;
    }

    public void setTaskID(Task taskID) {
        this.taskID = taskID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountplanID != null ? discountplanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountPlan)) {
            return false;
        }
        DiscountPlan other = (DiscountPlan) object;
        if ((this.discountplanID == null && other.discountplanID != null) || (this.discountplanID != null && !this.discountplanID.equals(other.discountplanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.DiscountPlan[ discountplanID=" + discountplanID + " ]";
    }
    
}
