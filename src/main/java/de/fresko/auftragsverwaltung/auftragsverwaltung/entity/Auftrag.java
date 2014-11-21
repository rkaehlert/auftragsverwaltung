package de.fresko.auftragsverwaltung.auftragsverwaltung.entity;

import de.fresko.auftragsverwaltung.exceptions.*;
import de.fresko.auftragsverwaltung.kundenverwaltung.entity.Kunde;
import de.fresko.auftragsverwaltung.userverwaltung.entity.FreskoUser;
import java.io.Serializable;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity
public class Auftrag implements Serializable {

    @Id
    private String jobnummer;
    private String eingangsdatum;
    //@ManyToMany
    private LinkedList<FreskoUser> bearbeiter;
    private String lieferart;
    private String beschreibung;
    private String besonderheiten;
    private String kontakt;
    private String rechnungsnummer;
    private String abschlussdatum;

    //@ManyToOne
    private Kunde kunde;

    //@OneToMany(fetch = FetchType.LAZY)
    private Set<Arbeitsschritt> arbeitsschritte;
    //@OneToMany(fetch = FetchType.LAZY)
    private Set<Fremdleistung> fremdleistungen;

    public Auftrag() {
    }

    public String getJobnummer() {
        return jobnummer;
    }

    public String getEingangsdatum() {
        return eingangsdatum;
    }

    public LinkedList<FreskoUser> getBearbeiter() {
        return bearbeiter;
    }

    public String getLieferart() {
        return lieferart;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getBesonderheiten() {
        return besonderheiten;
    }

    public String getKontakt() {
        return kontakt;
    }

    public String getRechnungsnummer() {
        return rechnungsnummer;
    }

    public String getAbschlussdatum() {
        return abschlussdatum;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Set<Arbeitsschritt> getArbeitsschritte() {
        return arbeitsschritte;
    }

    public Set<Fremdleistung> getFremdleistungen() {
        return fremdleistungen;
    }

    public void setJobnummer(String jobnummer) {
        this.jobnummer = jobnummer;
    }

    public void setEingangsdatum(String eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }

    public void setBearbeiter(LinkedList<FreskoUser> bearbeiter) {
        this.bearbeiter = bearbeiter;
    }

    public void setLieferart(String lieferart) {
        this.lieferart = lieferart;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void setBesonderheiten(String besonderheiten) {
        this.besonderheiten = besonderheiten;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public void setRechnungsnummer(String rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public void setAbschlussdatum(String abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setArbeitsschritte(Set<Arbeitsschritt> arbeitsschritte) {
        this.arbeitsschritte = arbeitsschritte;
    }

    public void setFremdleistungen(Set<Fremdleistung> fremdleistungen) {
        this.fremdleistungen = fremdleistungen;
    }

    public String erzeugeJobnummer() throws JobnummerException {
//		String jobnummer = null;
//		StringTokenizer st;
//		
//		try
//		{
//			ResultSet rs = stmtSelectDate.executeQuery("SELECT DATE_FORMAT (CURRENT_DATE(), '%Y') AS jahr, DATE_FORMAT (CURRENT_DATE(), '%m') AS monat");
//			rs.next();
//
//			int aktuellesJahr = rs.getInt("jahr");
//			int aktuellerMonat = rs.getInt("monat");
//			
//			rs = stmtSelectDate.executeQuery("SELECT * FROM settings WHERE settings_name = 'letzterAuftrag'");
//			rs.next();
//			String letzterAuftrag = rs.getString("settings_wert");
//			
//			st = new StringTokenizer(letzterAuftrag, "-");
//			
//			int letztesJahr = Integer.valueOf(st.nextToken());
//			int letzterMonat = Integer.valueOf(st.nextToken());
//			int letzteNummer = Integer.valueOf(st.nextToken());
//			
//			if(aktuellesJahr >= letztesJahr)
//			{
//				if(aktuellesJahr > letztesJahr)
//				{
//					if(aktuellerMonat < letzterMonat)
//					{
//						jobnummer = aktuellesJahr+"-"+String.format("%02d",aktuellerMonat)+"-"+String.format("%03d", 1);												
//					}
//					else
//					{
//						throw new JobnummerException();
//					}
//				}
//				else
//				{
//					if(aktuellerMonat == letzterMonat)
//					{
//						jobnummer = aktuellesJahr+"-"+String.format("%02d",aktuellerMonat)+"-"+String.format("%03d", ++letzteNummer);						
//					}
//					else if(aktuellerMonat > letzterMonat)
//					{
//						jobnummer = aktuellesJahr+"-"+String.format("%02d",aktuellerMonat)+"-"+String.format("%03d", 1);						
//					}
//					else
//					{
//						throw new JobnummerException();
//					}
//				}
//			}
//			else
//			{
//				throw new JobnummerException();
//			}
//			
//		}
//		catch(SQLException sqlex) {JOptionPane.showMessageDialog(null, sqlex.getMessage());}
//		
        return jobnummer;
    }

//------------------------------------------Arbeitsschrittmethoden-----------------------------------------
//	private Set<Arbeitsschritt> arbeitsschritteLaden() throws SQLException
//	{
//		stmtSelectArbeitsschritte.setString(1, jobnummer);
//		ResultSet result_as = stmtSelectArbeitsschritte.executeQuery();
//			
//		while(result_as.next())
//		{
//			schritte.add(new Arbeitsschritt(result_as.getString("arbeitsschritt_id"), result_as.getString("arbeitsschritt_beschreibung"), result_as.getString("arbeitsschritt_wer"), result_as.getInt("arbeitsschritt_zeit"), result_as.getString("arbeitsschritt_wann")));
//		}
//		
//		return schritte;
//	}
}