package de.fresko.auftragsverwaltung.kundenverwaltung.entity;

import de.fresko.auftragsverwaltung.auftragsverwaltung.entity.Auftrag;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Kunde implements Serializable
{
    @Id
	private Long 				id;
	private String 				name;
	private String				plz;
	private String 				ort;
	private String 				strasse;

	private String 				ansprechpartner;
	private String 				mail;
	private String 				telefon;
	private String 				mobil;
	private String 				telefax;
    //@OneToMany(mappedBy = "kunde")
    private List<Auftrag> auftrags;

	
	public Kunde()
	{
//		//mysql 			= new Mysql();
//		//conn 			= mysql.getConnection();
//		stmtKundeName 	= conn.prepareStatement("SELECT * FROM view_kundendetails WHERE firma_name = ?");
//		stmtKundeId 	= conn.prepareStatement("SELECT * FROM view_kundendetails WHERE kunde_id = ?");
	}
	
	Kunde(int kundeId)
	{
		
	}
	
	Kunde(String kundeName)
	{
		
	}

    public void setId(long id) {
        this.id = id;
    }

        
        
	public String getAnsprechpartner()
	{
		return ansprechpartner;
	}

	public String getMail()
	{
		return mail;
	}

	public String getTelefon()
	{
		return telefon;
	}
	
	public String getMobil()
	{
		return mobil;
	}

	public String getTelefax()
	{
		return telefax;
	}

	public long getKundeId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}

	public String getPlz()
	{
		return plz;
	}

	public String getStadt()
	{
		return ort;
	}

	public String getStrasse()
	{
		return strasse;
	}

    public List<Auftrag> getAuftrags() {
        return auftrags;
    }

    public void setAuftrags(List<Auftrag> auftrags) {
        this.auftrags = auftrags;
    }
}
