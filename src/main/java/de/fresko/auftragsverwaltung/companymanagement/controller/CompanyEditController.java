package de.fresko.auftragsverwaltung.companymanagement.controller;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.data.CompanyListProducer;
import de.fresko.auftragsverwaltung.data.JobListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class CompanyEditController implements Serializable {

    @Inject
    private CompanyListProducer companyListProducer;

    public enum Mode {

        EDIT, ADD
    };

    private Company company;
    private Mode mode;

    public Company getJob() {
        return company;
    }

    public void setCompanyToEdit(Mode mode) {
        setCompanyToEdit(mode, new Company());
    }

    public void setCompanyToEdit(Mode mode, Company comp) {
        this.company = comp;
        this.mode = mode;
    }

    public void doSave() {
        if (getMode() == Mode.ADD) {
            companyListProducer.getCompanies().add(company);
        }
        else {
            int index = 0;
            for (Company next : companyListProducer.getCompanies()) {
                if (Objects.equals(next.getId(), this.company.getId())) {
                    companyListProducer.getCompanies().set(index, this.company);
                    System.out.println("Replaced Company.");
                }
                index++;
            }
        }
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
