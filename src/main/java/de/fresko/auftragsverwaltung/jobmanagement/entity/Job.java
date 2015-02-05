package de.fresko.auftragsverwaltung.jobmanagement.entity;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.exceptions.*;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.sql.Timestamp;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@NamedQueries({
    @NamedQuery(name=Job.findAll, query="SELECT j FROM Job j ORDER BY j.id DESC")
})
@Entity
public class Job implements Serializable {
    
    public static final String findAll = "Job.findAll";
    
    @Id
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateIncoming;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<FreskoUser> arranger = new ArrayList<>();
    private EnumDeliveryTypes delivery;
    private String description;
    private String note;
    private String invoiceNumber;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinished;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company customer;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Task> tasks = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER)
    private List<ExternalService> externalServices = new ArrayList<>();

    @ManyToOne
    private FreskoUser userLastEdited;
    private Timestamp dateAdded;
    private Timestamp dateLastEdited;
    
    public Job() {
        id = "job-123";
    }

    public void addTask(Task t) {
        this.tasks.add(t);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateIncoming() {
        return dateIncoming;
    }

    public void setDateIncoming(Date dateIncoming) {
        this.dateIncoming = dateIncoming;
    }

    public List<FreskoUser> getArranger() {
        return arranger;
    }

    public void setArranger(List<FreskoUser> arranger) {
        this.arranger = arranger;
    }

    public EnumDeliveryTypes getDelivery() {
        return delivery;
    }

    public void setDelivery(EnumDeliveryTypes delivery) {
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

    public Company getCustomer() {
        return customer;
    }

    public void setCustomer(Company customer) {
        this.customer = customer;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<ExternalService> getExternalServices() {
        return externalServices;
    }

    public void setExternalServices(List<ExternalService> externalServices) {
        this.externalServices = externalServices;
    }

    public FreskoUser getUserLastEdited() {
        return userLastEdited;
    }

    public void setUserLastEdited(FreskoUser userLastEdited) {
        this.userLastEdited = userLastEdited;
    }

    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Timestamp getDateLastEdited() {
        return dateLastEdited;
    }

    public void setDateLastEdited(Timestamp dateLastEdited) {
        this.dateLastEdited = dateLastEdited;
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
        return id;
    }
}
