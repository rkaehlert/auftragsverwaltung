package de.fresko.auftragsverwaltung.companymanagement.service;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
public class CompanyServiceBean implements CompanyService {

    @Inject
    EntityManager em;

    @Override
    public List<Company> getAllCopmanies() {
        TypedQuery<Company> query = em.createNamedQuery(Company.FIND_ALL, Company.class);
        return query.getResultList();
    }

    @Override
    public List<Company> getAllCustomers() {
        TypedQuery<Company> query = em.createNamedQuery(Company.FIND_CUSTOMERS, Company.class);
        return query.getResultList();
    }

    @Override
    public List<Company> getAllProviders() {
        TypedQuery<Company> query = em.createNamedQuery(Company.FIND_PROVIDERS, Company.class);
        return query.getResultList();
    }

    @Override
    public void addCompany(Company company) {
        em.persist(company);
    }

    @Override
    public void updateCompany(Company company) {
        em.merge(company);
    }
}
