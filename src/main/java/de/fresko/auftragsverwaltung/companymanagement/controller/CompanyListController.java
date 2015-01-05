package de.fresko.auftragsverwaltung.companymanagement.controller;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.jobmanagement.controller.JobEditController;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class CompanyListController implements Serializable {
    
    @Inject
    private CompanyEditController companyEditController;
    
    public String doAddCompany() {
        companyEditController.setCompanyToEdit(CompanyEditController.Mode.ADD);
        return Pages.COMPANY_EDIT;
    }
    
    public void doEditCompany(Company comp) {
        companyEditController.setCompanyToEdit(CompanyEditController.Mode.EDIT, comp);
        companyEditController.doSave();
        //return Pages.COMPANY_EDIT;
    }
    
    public String doDeleteJob(Job job) {
        return Pages.COMPANY_DELETE;
    }
}
