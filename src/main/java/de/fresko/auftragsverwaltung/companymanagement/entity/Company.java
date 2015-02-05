package de.fresko.auftragsverwaltung.companymanagement.entity;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
    @NamedQuery(name = Company.FIND_ALL, query = "SELECT c FROM Company c ORDER BY c.name"),
    @NamedQuery(name = Company.FIND_CUSTOMERS, query = "SELECT c FROM Company c WHERE c.isCustomer = 1 ORDER BY c.name"),
    @NamedQuery(name = Company.FIND_PROVIDERS, query = "SELECT c FROM Company c WHERE c.isProvider = 1 ORDER BY c.name")
})
@Entity
public class Company implements Serializable {
    
    public static final String FIND_ALL = "Company.findAll";
    public static final String FIND_CUSTOMERS = "Company.findCustomers";
    public static final String FIND_PROVIDERS = "Company.findProviders";
        
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String zip;
    private String town;
    private String street;
    private String housenumber;

    private String contactPerson;
    private String mail;
    private String phone;
    private String mobile;
    private String fax;
    
    private boolean isCustomer;
    private boolean isProvider;
    
    @OneToMany(mappedBy = "customer")
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    
    public Company() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public boolean getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }

    public boolean getIsProvider() {
        return isProvider;
    }

    public void setIsProvider(boolean isProvider) {
        this.isProvider = isProvider;
    }
    
        public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }    
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public boolean equals(Object obj) {
        Company comp = (Company)obj;
        return Objects.equals(comp.id, this.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
