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
@Table(name = "dicount_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DicountPlan.findAll", query = "SELECT d FROM DicountPlan d")
    , @NamedQuery(name = "DicountPlan.findByDicountplanID", query = "SELECT d FROM DicountPlan d WHERE d.dicountplanID = :dicountplanID")
    , @NamedQuery(name = "DicountPlan.findByRate", query = "SELECT d FROM DicountPlan d WHERE d.rate = :rate")
    , @NamedQuery(name = "DicountPlan.findByIsFlexible", query = "SELECT d FROM DicountPlan d WHERE d.isFlexible = :isFlexible")
    , @NamedQuery(name = "DicountPlan.findByVariableRate", query = "SELECT d FROM DicountPlan d WHERE d.variableRate = :variableRate")})
public class DicountPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dicount_planID")
    private Integer dicountplanID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rate")
    private Float rate;
    @Column(name = "is_flexible")
    private Short isFlexible;
    @Size(max = 45)
    @Column(name = "variable_rate")
    private String variableRate;
    @JoinColumn(name = "account_no", referencedColumnName = "account_no")
    @ManyToOne(optional = false)
    private Customer accountNo;
    @JoinColumn(name = "taskID", referencedColumnName = "taskID")
    @ManyToOne(optional = false)
    private Task taskID;

    public DicountPlan() {
    }

    public DicountPlan(Integer dicountplanID) {
        this.dicountplanID = dicountplanID;
    }

    public Integer getDicountplanID() {
        return dicountplanID;
    }

    public void setDicountplanID(Integer dicountplanID) {
        this.dicountplanID = dicountplanID;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Short getIsFlexible() {
        return isFlexible;
    }

    public void setIsFlexible(Short isFlexible) {
        this.isFlexible = isFlexible;
    }

    public String getVariableRate() {
        return variableRate;
    }

    public void setVariableRate(String variableRate) {
        this.variableRate = variableRate;
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
        hash += (dicountplanID != null ? dicountplanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DicountPlan)) {
            return false;
        }
        DicountPlan other = (DicountPlan) object;
        if ((this.dicountplanID == null && other.dicountplanID != null) || (this.dicountplanID != null && !this.dicountplanID.equals(other.dicountplanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.DicountPlan[ dicountplanID=" + dicountplanID + " ]";
    }
    
}
