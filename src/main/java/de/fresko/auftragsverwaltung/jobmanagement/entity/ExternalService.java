package de.fresko.auftragsverwaltung.jobmanagement.entity;

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
    private String beschreibung;
    private double kosten;
    private String datum;
    private boolean bearbeitet;

    @ManyToOne
    private Provider lieferant;

    public ExternalService(String beschreibung, double kosten, int lieferantId, String datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.kosten = kosten;
        this.datum = datum;
        this.lieferant = new Provider(lieferantId);
        bearbeitet = false;
    }

    public ExternalService(String beschreibung, double kosten, String lieferantName, String datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.kosten = kosten;
        this.datum = datum;
        this.lieferant = new Provider(lieferantName);
        bearbeitet = false;
    }

    //Getter und Setter
    public long getId() {
        return id;
    }

    public long getIntId() {
        return id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public Provider getLieferant() {
        return lieferant;
    }

    public void setLieferant(String name) {
        lieferant = new Provider(name);
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
