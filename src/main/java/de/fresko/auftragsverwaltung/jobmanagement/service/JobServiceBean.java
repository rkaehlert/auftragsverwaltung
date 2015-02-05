package de.fresko.auftragsverwaltung.jobmanagement.service;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import de.fresko.auftragsverwaltung.util.Resources;
import javax.ejb.Stateless;

@Stateless
public class JobServiceBean implements JobService {

    @Inject
    private EntityManager em;

    @Override
    public List<Job> getAllJobs() {
        TypedQuery<Job> query = em.createNamedQuery(Job.findAll, Job.class);
        return query.getResultList();
    }

    @Override
    public void addJob(Job job) {
        em.persist(job);
    }

    @Override
    public void updateJob(Job job) {
        em.merge(job);
    }

    @Override
    public void deleteJob(Job job) {
        Job managedJob = em.find(Job.class, job.getId());
        em.remove(managedJob);
    }

}
