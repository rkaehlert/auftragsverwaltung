package de.fresko.auftragsverwaltung.usermanagement.entity;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.usermanagement.service.FreskoUserPasswordService;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

@NamedQueries({
    @NamedQuery(
            name = FreskoUser.FIND_BY_USERNAME,
            query = "SELECT u FROM FreskoUser u WHERE u.username = :" + FreskoUser.PARAM_USERNAME
    ),
    @NamedQuery(
            name = FreskoUser.FIND_ALL,
            query = "SELECT u FROM FreskoUser u"
    )})
@Entity
public class FreskoUser implements Serializable {

    public static final String FIND_BY_USERNAME = "User.FinyByUsername";
    public static final String FIND_ALL = "User.findAll";
    public static final String PARAM_USERNAME = "username";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @Size(min = 2, max = 240)
    private String username;
    private String password;

    private String firstname;
    private String lastname;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastLogin;
    @ManyToMany(mappedBy = "arranger", fetch = FetchType.EAGER)
    private List<Job> jobs;

    public FreskoUser() {
    }

    public FreskoUser(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public FreskoUser(String email, String password, Date lastLogin) {
        this.username = email;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public boolean checkPassword(String testPassword) {
        return new FreskoUserPasswordService().checkPW(testPassword, this.password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }

    @Override
    public boolean equals(Object obj) {
        FreskoUser user = (FreskoUser) obj;
        return Objects.equals(user.id, this.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.username);
        return hash;
    }
}
