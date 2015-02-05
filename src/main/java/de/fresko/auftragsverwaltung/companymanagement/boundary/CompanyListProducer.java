package de.fresko.auftragsverwaltung.companymanagement.boundary;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.companymanagement.service.CompanyService;
import de.fresko.auftragsverwaltung.util.Events;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
public class CompanyListProducer {

    @Inject
    CompanyService companyService;
    
    private List<Company> companies = new ArrayList<>();
    private List<Company> customers = new ArrayList<>();
    private List<Company> providers = new ArrayList<>();

    @PostConstruct
    public void init() {
        companies = companyService.getAllCopmanies();
        customers = companyService.getAllCustomers();
        providers = companyService.getAllProviders();
    }

    public void onCompanyAdded(@Observes @Events.Added Company company){
        companyService.addCompany(company);
        init();
    }
    
    public void onCompanyUpdated(@Observes @Events.Updated Company company){
        companyService.updateCompany(company);
        init();
    }
    
    @Named
    @Produces
    public List<Company> getProviders() {
        return providers;
    }
    
    @Named
    @Produces
    public List<Company> getCustomers() {
        return customers;
    }

    @Named
    @Produces
    public List<Company> getCompanies() {
        return companies;
    }
}
