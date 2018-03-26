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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DanTe
 */
@Entity
@Table(name = "job_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobLine.findAll", query = "SELECT j FROM JobLine j")
    , @NamedQuery(name = "JobLine.findByJoblineID", query = "SELECT j FROM JobLine j WHERE j.joblineID = :joblineID")
    , @NamedQuery(name = "JobLine.findByDate", query = "SELECT j FROM JobLine j WHERE j.date = :date")
    , @NamedQuery(name = "JobLine.findByStartTime", query = "SELECT j FROM JobLine j WHERE j.startTime = :startTime")
    , @NamedQuery(name = "JobLine.findByEndTime", query = "SELECT j FROM JobLine j WHERE j.endTime = :endTime")})
public class JobLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Job_lineID")
    private Integer joblineID;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Job code;
    @JoinColumn(name = "completed_by", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Staff completedBy;
    @JoinColumn(name = "TaskID", referencedColumnName = "TaskID")
    @ManyToOne(optional = false)
    private Task taskID;

    public JobLine() {
    }

    public JobLine(Integer joblineID) {
        this.joblineID = joblineID;
    }

    public Integer getJoblineID() {
        return joblineID;
    }

    public void setJoblineID(Integer joblineID) {
        this.joblineID = joblineID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Job getCode() {
        return code;
    }

    public void setCode(Job code) {
        this.code = code;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (joblineID != null ? joblineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobLine)) {
            return false;
        }
        JobLine other = (JobLine) object;
        if ((this.joblineID == null && other.joblineID != null) || (this.joblineID != null && !this.joblineID.equals(other.joblineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.JobLine[ joblineID=" + joblineID + " ]";
    }
    
}
