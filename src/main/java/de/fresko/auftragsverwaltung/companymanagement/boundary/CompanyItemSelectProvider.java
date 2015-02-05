package de.fresko.auftragsverwaltung.companymanagement.boundary;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class CompanyItemSelectProvider implements Serializable {

    @Inject
    private CompanyListProducer companies;
    private Company selectedCompany;

    public List<Company> getCompanies() {
        return companies.getCompanies();
    }
    
    public List<Company> getCustomers() {
        return companies.getCustomers();
    }

    public List<Company> getProviders() {
        return companies.getProviders();
    }
    
    public Company getSelectedEntity() {
        return selectedCompany;
    }

    public void setSelectedEntity(Company selectedEntity) {
        this.selectedCompany = selectedEntity;
    }
}
