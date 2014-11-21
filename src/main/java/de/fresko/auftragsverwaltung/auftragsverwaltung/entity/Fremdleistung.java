package de.fresko.auftragsverwaltung.auftragsverwaltung.entity;

import de.fresko.auftragsverwaltung.lieferantenverwaltung.entity.Lieferant;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fremdleistung implements Serializable {

    @Id
    private String id;
    private String beschreibung;
    private double kosten;
    private String datum;
    private boolean bearbeitet;

    @ManyToOne
    private Lieferant lieferant;

    public Fremdleistung(String id, String beschreibung, double kosten, int lieferantId, String datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.kosten = kosten;
        this.datum = datum;
        this.lieferant = new Lieferant(lieferantId);
        bearbeitet = false;
    }

    public Fremdleistung(String id, String beschreibung, double kosten, String lieferantName, String datum) {
        this.id = id;
        this.beschreibung = beschreibung;
        this.kosten = kosten;
        this.datum = datum;
        this.lieferant = new Lieferant(lieferantName);
        bearbeitet = false;
    }

    //Getter und Setter
    public String getId() {
        return id;
    }

    public int getIntId() {
        return Integer.valueOf(id);
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

    public Lieferant getLieferant() {
        return lieferant;
    }

    public void setLieferant(String name) {
        lieferant = new Lieferant(name);
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
