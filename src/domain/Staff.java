/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tweetie Pie
 */
@Entity
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.searchByUsername", query = "SELECT s FROM Staff s WHERE s.username LIKE CONCAT('%',:username,'%')")
    , @NamedQuery(name = "Staff.findByUsername", query = "SELECT s FROM Staff s WHERE s.username = :username")    
    , @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password")
    , @NamedQuery(name = "Staff.findByFirstName", query = "SELECT s FROM Staff s WHERE s.forename = :forename")
    , @NamedQuery(name = "Staff.findBySurname", query = "SELECT s FROM Staff s WHERE s.surname = :surname")
    , @NamedQuery(name = "Staff.findByRole", query = "SELECT s FROM Staff s WHERE s.role = :role")
    , @NamedQuery(name = "Staff.updateStaff", query = "UPDATE  Staff SET forename =:forename, surname = :surname, password = password, role=role" +" WHERE username = username")})
public class Staff implements Serializable {

    @OneToMany(mappedBy = "completedBy")
    private Collection<TaskLine> taskLineCollection;

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Size(max = 30)
    @Column(name = "forename")
    private String forename;
    @Size(max = 30)
    @Column(name = "surname")
    private String surname;
    @Size(max = 20)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Version
    @Column(name = "version")
    private long version;
    @Column(name = "logged_on")
    private Boolean loggedOn;

    public Staff() {
    }

    public Staff(String username) {
        this.username = username;
    }

    public Staff(String username, String password, long version) {
        this.username = username;
        this.password = password;
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Boolean getLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(Boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Staff[ username=" + username + " ]";
    }

    @XmlTransient
    public Collection<TaskLine> getTaskLineCollection() {
        return taskLineCollection;
    }

    public void setTaskLineCollection(Collection<TaskLine> taskLineCollection) {
        this.taskLineCollection = taskLineCollection;
    }
    
}
