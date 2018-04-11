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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    , @NamedQuery(name = "TaskLine.findByNullStartTime", query = "SELECT t FROM TaskLine t WHERE t.startTime IS NULL")
    , @NamedQuery(name = "TaskLine.findByEndTime", query = "SELECT t FROM TaskLine t WHERE t.endTime = :endTime")
    , @NamedQuery(name = "TaskLine.findByShelf", query = "SELECT t FROM TaskLine t WHERE t.shelf = :shelf")
    , @NamedQuery(name = "TaskLine.findPerformanceReport", query = "SELECT j FROM TaskLine j  WHERE j.startTime = :startTime ORDER BY j.completedBy ASC, j.startTime ASC ")
    , @NamedQuery(name = "TaskLine.findBetweenDates", query = "SELECT t FROM TaskLine t WHERE t.startTime BETWEEN :startDate AND :endDate ORDER BY t.completedBy ASC,  t.startTime ASC")
    , @NamedQuery(name = "TaskLine.findBetweenDates2", query = "SELECT t FROM TaskLine t WHERE t.startTime BETWEEN :startDate AND :endDate ORDER BY   t.startTime ASC")
    , @NamedQuery(name = "TaskLine.findSummaryReport", query = "SELECT t FROM TaskLine t WHERE t.startTime BETWEEN :startDATE AND :endDATE ORDER BY CASE WHEN t.taskID.department = 'Copy Room' THEN 'Copy Room' WHEN t.taskID.department = 'Development Area' THEN 'Development Area' WHEN t.taskID.department = 'Packing Departments' THEN 'Packing Departments' WHEN t.taskID.department = 'Finishing Room' THEN 'Finishing Room'\n" +

"                   ELSE '' END" )  
    , @NamedQuery(name = "TaskLine.findByVersion", query = "SELECT t FROM TaskLine t WHERE t.version = :version")})
public class TaskLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "task_lineID")
    private Integer tasklineID;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 10)
    @Column(name = "shelf")
    private String shelf;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @JoinColumn(name = "completed_by", referencedColumnName = "username")
    @ManyToOne
    private Staff completedBy;
    @JoinColumn(name = "taskID", referencedColumnName = "taskID")
    @ManyToOne(optional = false)
    private Task taskID;
    @JoinColumn(name = "job_lineID", referencedColumnName = "job_lineID")
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
