package de.fresko.auftragsverwaltung.jobmanagement.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String beschreibung;
    private int zeit;
    private String bearbeiter;
    private String datum;
    private boolean bearbeitet;

    public Task() {
    }

    public Task(long id, String beschreibung, String bearbeiter, int zeit, String datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.zeit = zeit;
        this.bearbeiter = bearbeiter;
        this.datum = datum;
        bearbeitet = false;
    }

    public long getId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getZeit() {
        return zeit;
    }

    public void setZeit(int zeit) {
        this.zeit = zeit;
    }

    public String getBearbeiter() {
        return bearbeiter;
    }

    public void setBearbeiter(String bearbeiter) {
        this.bearbeiter = bearbeiter;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setBearbeitet() {
        bearbeitet = true;
    }

    public boolean isBearbeitet() {
        return bearbeitet;
    }
}
