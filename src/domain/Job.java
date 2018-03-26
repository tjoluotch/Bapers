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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DanTe
 */
@Entity
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j")
    , @NamedQuery(name = "Job.findByCode", query = "SELECT j FROM Job j WHERE j.code = :code")
    , @NamedQuery(name = "Job.findByJobDescription", query = "SELECT j FROM Job j WHERE j.jobDescription = :jobDescription")
    , @NamedQuery(name = "Job.findByPrice", query = "SELECT j FROM Job j WHERE j.price = :price")
    , @NamedQuery(name = "Job.findByJobDeadline", query = "SELECT j FROM Job j WHERE j.jobDeadline = :jobDeadline")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "code")
    private String code;
    @Column(name = "job_description")
    private String jobDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "job_deadline")
    @Temporal(TemporalType.DATE)
    private Date jobDeadline;
    @JoinColumn(name = "orderID", referencedColumnName = "orderID")
    @ManyToOne(optional = false)
    private OrderTable orderID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<JobLine> jobLineCollection;

    public Job() {
    }

    public Job(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getJobDeadline() {
        return jobDeadline;
    }

    public void setJobDeadline(Date jobDeadline) {
        this.jobDeadline = jobDeadline;
    }

    public OrderTable getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderTable orderID) {
        this.orderID = orderID;
    }

    @XmlTransient
    public Collection<JobLine> getJobLineCollection() {
        return jobLineCollection;
    }

    public void setJobLineCollection(Collection<JobLine> jobLineCollection) {
        this.jobLineCollection = jobLineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Job[ code=" + code + " ]";
    }
    
}
