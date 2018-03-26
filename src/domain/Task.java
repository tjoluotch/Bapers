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
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findByTaskID", query = "SELECT t FROM Task t WHERE t.taskID = :taskID")
    , @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description")
    , @NamedQuery(name = "Task.findByDepartment", query = "SELECT t FROM Task t WHERE t.department = :department")
    , @NamedQuery(name = "Task.findByShelf", query = "SELECT t FROM Task t WHERE t.shelf = :shelf")
    , @NamedQuery(name = "Task.findByPrice", query = "SELECT t FROM Task t WHERE t.price = :price")
    , @NamedQuery(name = "Task.findByExpectedDuration", query = "SELECT t FROM Task t WHERE t.expectedDuration = :expectedDuration")})
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TaskID")
    private Integer taskID;
    @Column(name = "description")
    private String description;
    @Column(name = "department")
    private String department;
    @Column(name = "shelf")
    private String shelf;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "expected_duration")
    @Temporal(TemporalType.TIME)
    private Date expectedDuration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskID")
    private Collection<JobLine> jobLineCollection;

    public Task() {
    }

    public Task(Integer taskID) {
        this.taskID = taskID;
    }

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(Date expectedDuration) {
        this.expectedDuration = expectedDuration;
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
        hash += (taskID != null ? taskID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.taskID == null && other.taskID != null) || (this.taskID != null && !this.taskID.equals(other.taskID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Task[ taskID=" + taskID + " ]";
    }
    
}
