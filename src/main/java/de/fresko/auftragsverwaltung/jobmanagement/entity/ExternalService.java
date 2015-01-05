package de.fresko.auftragsverwaltung.jobmanagement.entity;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.providermanagement.entity.Provider;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExternalService implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private double cost;
    private String dateFinished;
    private boolean finished;

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

    public String getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(String dateFinished) {
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
