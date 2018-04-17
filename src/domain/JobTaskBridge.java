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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "job_task-bridge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobTaskBridge.findAll", query = "SELECT j FROM JobTaskBridge j")
    , @NamedQuery(name = "JobTaskBridge.findByBridgeID", query = "SELECT j FROM JobTaskBridge j WHERE j.bridgeID = :bridgeID")
    , @NamedQuery(name = "JobTaskBridge.findByVersion", query = "SELECT j FROM JobTaskBridge j WHERE j.version = :version")})
public class JobTaskBridge implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bridgeID")
    private Long bridgeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @JoinColumn(name = "code", referencedColumnName = "code")
    @ManyToOne(optional = false)
    private Job code;
    @JoinColumn(name = "taskID", referencedColumnName = "taskID")
    @ManyToOne(optional = false)
    private Task taskID;

    public JobTaskBridge() {
    }

    public JobTaskBridge(Long bridgeID) {
        this.bridgeID = bridgeID;
    }

    public JobTaskBridge(Long bridgeID, long version) {
        this.bridgeID = bridgeID;
        this.version = version;
    }

    public Long getBridgeID() {
        return bridgeID;
    }

    public void setBridgeID(Long bridgeID) {
        this.bridgeID = bridgeID;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Job getCode() {
        return code;
    }

    public void setCode(Job code) {
        this.code = code;
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
        hash += (bridgeID != null ? bridgeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobTaskBridge)) {
            return false;
        }
        JobTaskBridge other = (JobTaskBridge) object;
        if ((this.bridgeID == null && other.bridgeID != null) || (this.bridgeID != null && !this.bridgeID.equals(other.bridgeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.JobTaskBridge[ bridgeID=" + bridgeID + " ]";
    }
    
}
