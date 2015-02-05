package de.fresko.auftragsverwaltung.jobmanagement.entity;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class ExternalService implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private double cost;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinished;
    private boolean finished;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTaskAdded;
    @ManyToOne
    private FreskoUser userTaskAdded;

    @ManyToOne
    private Company provider;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Company getProvider() {
        return provider;
    }

    public void setProvider(Company provider) {
        this.provider = provider;
    }
}
