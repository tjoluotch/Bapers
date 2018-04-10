/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "task_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskLine.findAll", query = "SELECT t FROM TaskLine t")
    , @NamedQuery(name = "TaskLine.findByTasklineID", query = "SELECT t FROM TaskLine t WHERE t.tasklineID = :tasklineID")
    , @NamedQuery(name = "TaskLine.findByStartTime", query = "SELECT t FROM TaskLine t WHERE t.startTime = :startTime")
    , @NamedQuery(name = "TaskLine.findByEndTime", query = "SELECT t FROM TaskLine t WHERE t.endTime = :endTime")
    , @NamedQuery(name = "TaskLine.findByShelf", query = "SELECT t FROM TaskLine t WHERE t.shelf = :shelf")
    , @NamedQuery(name = "TaskLine.findByVersion", query = "SELECT t FROM TaskLine t WHERE t.version = :version")})
public class TaskLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "task_lineID", nullable = false)
    private Integer tasklineID;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 10)
    @Column(name = "shelf", length = 10)
    private String shelf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version", nullable = false)
    private long version;
    @JoinColumn(name = "completed_by", referencedColumnName = "username")
    @ManyToOne
    private Staff completedBy;
    @JoinColumn(name = "taskID", referencedColumnName = "taskID", nullable = false)
    @ManyToOne(optional = false)
    private Task taskID;
    @JoinColumn(name = "job_lineID", referencedColumnName = "job_lineID", nullable = false)
    @ManyToOne(optional = false)
    private JobLine joblineID;

    public TaskLine() {
    }

    public TaskLine(Integer tasklineID) {
        this.tasklineID = tasklineID;
    }

    public TaskLine(Integer tasklineID, long version) {
        this.tasklineID = tasklineID;
        this.version = version;
    }

    public Integer getTasklineID() {
        return tasklineID;
    }

    public void setTasklineID(Integer tasklineID) {
        this.tasklineID = tasklineID;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Staff getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(Staff completedBy) {
        this.completedBy = completedBy;
    }

    public Task getTaskID() {
        return taskID;
    }

    public void setTaskID(Task taskID) {
        this.taskID = taskID;
    }

    public JobLine getJoblineID() {
        return joblineID;
    }

    public void setJoblineID(JobLine joblineID) {
        this.joblineID = joblineID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tasklineID != null ? tasklineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskLine)) {
            return false;
        }
        TaskLine other = (TaskLine) object;
        if ((this.tasklineID == null && other.tasklineID != null) || (this.tasklineID != null && !this.tasklineID.equals(other.tasklineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TaskLine[ tasklineID=" + tasklineID + " ]";
    }
    
}
