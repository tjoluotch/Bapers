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
@Table(name = "customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByAccountNo", query = "SELECT c FROM Customer c WHERE c.accountNo = :accountNo")
    , @NamedQuery(name = "Customer.findByForename", query = "SELECT c FROM Customer c WHERE c.forename = :forename")
    , @NamedQuery(name = "Customer.findBySurname", query = "SELECT c FROM Customer c WHERE c.surname = :surname")
    , @NamedQuery(name = "Customer.findByAccountHolderName", query = "SELECT c FROM Customer c WHERE c.accountHolderName = :accountHolderName")
    , @NamedQuery(name = "Customer.findByTitle", query = "SELECT c FROM Customer c WHERE c.title = :title")
    , @NamedQuery(name = "Customer.findByAddress1", query = "SELECT c FROM Customer c WHERE c.address1 = :address1")
    , @NamedQuery(name = "Customer.findByAddress2", query = "SELECT c FROM Customer c WHERE c.address2 = :address2")
    , @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.city = :city")
    , @NamedQuery(name = "Customer.findByRegion", query = "SELECT c FROM Customer c WHERE c.region = :region")
    , @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByEmail", query = "SELECT c FROM Customer c WHERE c.email = :email")
    , @NamedQuery(name = "Customer.findByValuedCustomer", query = "SELECT c FROM Customer c WHERE c.valuedCustomer = :valuedCustomer")
    , @NamedQuery(name = "Customer.findByDiscountType", query = "SELECT c FROM Customer c WHERE c.discountType = :discountType")
    , @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status")
    , @NamedQuery(name = "Customer.findByVersion", query = "SELECT c FROM Customer c WHERE c.version = :version")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "account_no")
    private String accountNo;
    @Size(max = 30)
    @Column(name = "forename")
    private String forename;
    @Size(max = 30)
    @Column(name = "surname")
    private String surname;
    @Size(max = 45)
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 20)
    @Column(name = "address1")
    private String address1;
    @Size(max = 20)
    @Column(name = "address2")
    private String address2;
    @Size(max = 20)
    @Column(name = "city")
    private String city;
    @Size(max = 20)
    @Column(name = "region")
    private String region;
    @Size(max = 9)
    @Column(name = "postcode")
    private String postcode;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Column(name = "valued_customer")
    private Boolean valuedCustomer;
    @Size(max = 45)
    @Column(name = "discount_type")
    private String discountType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNo")
    private Collection<Alert> alertCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNo")
    private Collection<DiscountPlan> discountPlanCollection;
    @OneToMany(mappedBy = "accountNo")
    private Collection<OrderTable> orderTableCollection;

    public Customer() {
    }

    public Customer(String accountNo) {
        this.accountNo = accountNo;
    }

    public Customer(String accountNo, String status, long version) {
        this.accountNo = accountNo;
        this.status = status;
        this.version = version;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getValuedCustomer() {
        return valuedCustomer;
    }

    public void setValuedCustomer(Boolean valuedCustomer) {
        this.valuedCustomer = valuedCustomer;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<Alert> getAlertCollection() {
        return alertCollection;
    }

    public void setAlertCollection(Collection<Alert> alertCollection) {
        this.alertCollection = alertCollection;
    }

    @XmlTransient
    public Collection<DiscountPlan> getDiscountPlanCollection() {
        return discountPlanCollection;
    }

    public void setDiscountPlanCollection(Collection<DiscountPlan> discountPlanCollection) {
        this.discountPlanCollection = discountPlanCollection;
    }

    @XmlTransient
    public Collection<OrderTable> getOrderTableCollection() {
        return orderTableCollection;
    }

    public void setOrderTableCollection(Collection<OrderTable> orderTableCollection) {
        this.orderTableCollection = orderTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNo != null ? accountNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.accountNo == null && other.accountNo != null) || (this.accountNo != null && !this.accountNo.equals(other.accountNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Customer[ accountNo=" + accountNo + " ]";
    }
    
}
