package de.fresko.auftragsverwaltung.companymanagement.service;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@Alternative
public class MockCompanyServiceBean implements CompanyService {
    
    private void createMockCompanies() {
        List<Company> companies= new ArrayList<>();
        
        Company c1 = new Company();
        c1.setId(1L);
        c1.setName("Bad Blau");
        c1.setZip("12345");
        c1.setIsCustomer(true);
        
        Company c2 = new Company();
        c2.setId(2L);
        c2.setName("Würzburg Vegan");
        c2.setTown("Würzburg");
        c2.setIsCustomer(true);

        companies.add(c1);
        companies.add(c2);
        
        Company c3 = new Company();
        c3.setId(3L);
        c3.setName("Prinzing");
        c3.setZip("12345");
        c3.setIsProvider(true);

        Company c4 = new Company();
        c4.setId(4L);
        c4.setName("Papyrus");
        c4.setTown("Ulm");
        c4.setIsProvider(true);

        companies.add(c3);
        companies.add(c4);
    }

    @Override
    public List<Company> getAllCopmanies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Company> getAllProviders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCompany(Company company) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
