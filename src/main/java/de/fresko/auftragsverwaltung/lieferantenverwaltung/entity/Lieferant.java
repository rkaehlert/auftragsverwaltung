package de.fresko.auftragsverwaltung.lieferantenverwaltung.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lieferant implements Serializable {

    @Id
    private long id;
    private String name;
    private String ort;
    private String plz;
    private String strasse;

    private String ansprechpartner;
    private String mail;
    private String telefon;
    private String mobil;
    private String telefax;

    public Lieferant() {
//		mysql 					= new Mysql();
//		conn 					= mysql.getConnection();
//		
//		stmtLieferantName 		= conn.prepareStatement("SELECT * FROM view_lieferantendetails WHERE firma_name = ?");
//		stmtLieferantId 		= conn.prepareStatement("SELECT * FROM view_lieferantendetails WHERE lieferant_id = ?");
    }

    public Lieferant(int lieferantId) {
    }

    public Lieferant(String lieferantName) {
    }

    public long getLieferantId() {
        return id;
    }

    public void setLieferantId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPlz() {
        return plz;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getOrt() {
        return ort;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getMobil() {
        return mobil;
    }

    public String getTelefax() {
        return telefax;
    }
}
