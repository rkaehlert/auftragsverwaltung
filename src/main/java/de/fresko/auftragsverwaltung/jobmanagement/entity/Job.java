package de.fresko.auftragsverwaltung.jobmanagement.entity;

import de.fresko.auftragsverwaltung.exceptions.*;
import de.fresko.auftragsverwaltung.customermanagement.entity.Customer;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Job implements Serializable {

    @Id
    private String jobID;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateIncoming;
    @ManyToMany
    private Set<FreskoUser> arranger;
    private String delivery;
    private String description;
    private String note;
    private String contact;
    private String invoiceNumber;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinished;

    @ManyToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Task> tasks;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ExternalService> externalServices;

    public Job() {
    }

    public String getjobID() {
        return jobID;
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public Date getDateIncoming() {
        return dateIncoming;
    }

    public void setDateIncoming(Date dateIncoming) {
        this.dateIncoming = dateIncoming;
    }

    public Set<FreskoUser> getArranger() {
        return arranger;
    }

    public void setArranger(Set<FreskoUser> bearbeiter) {
        this.arranger = bearbeiter;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<ExternalService> getExternalServices() {
        return externalServices;
    }

    public void setExternalServices(Set<ExternalService> externalServices) {
        this.externalServices = externalServices;
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
        return jobID;
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