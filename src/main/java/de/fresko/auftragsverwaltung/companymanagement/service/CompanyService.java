package de.fresko.auftragsverwaltung.companymanagement.service;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import java.util.List;

public interface CompanyService {
    List<Company> getAllCopmanies();
    List<Company> getAllCustomers();
    List<Company> getAllProviders();
    void addCompany(Company company);
    void updateCompany(Company company);
}
