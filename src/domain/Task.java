/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findByTaskID", query = "SELECT t FROM Task t WHERE t.taskID = :taskID")
    , @NamedQuery(name = "Task.findByDescription", query = "SELECT t FROM Task t WHERE t.description = :description")
    , @NamedQuery(name = "Task.findByDepartment", query = "SELECT t FROM Task t WHERE t.department = :department")
    , @NamedQuery(name = "Task.findByPrice", query = "SELECT t FROM Task t WHERE t.price = :price")
    , @NamedQuery(name = "Task.findByExpectedDuration", query = "SELECT t FROM Task t WHERE t.expectedDuration = :expectedDuration")
    , @NamedQuery(name = "Task.findByVersion", query = "SELECT t FROM Task t WHERE t.version = :version")})
public class Task implements Serializable {

    @OneToMany(mappedBy = "taskID")
    private Collection<DiscountPlan> discountPlanCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskID")
    private Collection<TaskLine> taskLineCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "taskID")
    private Integer taskID;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "department")
    private String department;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @Column(name = "expected_duration")
    private Integer expectedDuration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskID")
    private Collection<JobTaskBridge> jobTaskBridgeCollection;

    public Task() {
    }

    public Task(Integer taskID) {
        this.taskID = taskID;
    }

    public Task(Integer taskID, long version) {
        this.taskID = taskID;
        this.version = version;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(Integer expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<JobTaskBridge> getJobTaskBridgeCollection() {
        return jobTaskBridgeCollection;
    }

    public void setJobTaskBridgeCollection(Collection<JobTaskBridge> jobTaskBridgeCollection) {
        this.jobTaskBridgeCollection = jobTaskBridgeCollection;
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

    @XmlTransient
    public Collection<TaskLine> getTaskLineCollection() {
        return taskLineCollection;
    }

    public void setTaskLineCollection(Collection<TaskLine> taskLineCollection) {
        this.taskLineCollection = taskLineCollection;
    }

    @XmlTransient
    public Collection<DiscountPlan> getDiscountPlanCollection() {
        return discountPlanCollection;
    }

    public void setDiscountPlanCollection(Collection<DiscountPlan> discountPlanCollection) {
        this.discountPlanCollection = discountPlanCollection;
    }
    
}
