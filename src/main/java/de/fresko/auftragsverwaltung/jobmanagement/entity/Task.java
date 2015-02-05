package de.fresko.auftragsverwaltung.jobmanagement.entity;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String description;
    private int neededTime;
    @ManyToMany
    private List<FreskoUser> arranger;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinished;
    private boolean finished;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTaskAdded;
    @ManyToOne
    private FreskoUser userTaskAdded;
    
    public Task() {
    }

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

    public int getNeededTime() {
        return neededTime;
    }

    public void setNeededTime(int neededTime) {
        this.neededTime = neededTime;
    }

    public List<FreskoUser> getArranger() {
        return arranger;
    }

    public void setArranger(List<FreskoUser> arranger) {
        this.arranger = arranger;
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
}
