package de.fresko.auftragsverwaltung.data;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class CompanyListProducer implements Serializable{

    private ArrayList<Company> companies = new ArrayList<>();

    @PostConstruct
    public void init() {
        createMockCompanies();
    }

    public ArrayList<Company> getProviders() {
        ArrayList<Company> returnValue = new ArrayList<>();
        for (Company c : companies) {
            if(c.getIsProvider()) returnValue.add(c);
        }
        return returnValue;
    }
    
    public ArrayList<Company> getCustomers() {
        ArrayList<Company> returnValue = new ArrayList<>();
        for (Company c : companies) {
            if(c.getIsCustomer()) returnValue.add(c);
        }
        return returnValue;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }
    
    private void createMockCompanies() {
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
}
