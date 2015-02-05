package de.fresko.auftragsverwaltung.companymanagement.controller;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.companymanagement.boundary.CompanyListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.boundary.JobListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.util.Events;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class CompanyEditController implements Serializable {

    @Inject
    private CompanyListProducer companyListProducer;

    @Inject @Events.Added
    private Event<Company> companyAddEventSrc;
    
    @Inject @Events.Updated
    private Event<Company> companyUpdateEventSrc;
    
    public enum Mode {
        EDIT, ADD
    };

    private Company company;
    private Mode mode;

    public Company getCompany() {
        return company;
    }

    public void setCompanyToEdit(Mode mode) {
        setCompanyToEdit(mode, new Company());
    }

    public void setCompanyToEdit(Mode mode, Company comp) {
        this.company = comp;
        this.mode = mode;
    }

    public String doSave() {
        if (getMode() == Mode.ADD) {
            companyAddEventSrc.fire(company);
        }
        else if(getMode() == Mode.EDIT) {
            companyUpdateEventSrc.fire(company);
        }
        return Pages.COMPANY_LIST;
    }

    public String doCancel() {
        return Pages.COMPANY_LIST;
    }

    public String getTitle() {
        return getMode() == Mode.EDIT ? "Firma bearbeiten" : "Neue Firma anlegen";
    }

    private Mode getMode() {
        return this.mode;
    }
}
