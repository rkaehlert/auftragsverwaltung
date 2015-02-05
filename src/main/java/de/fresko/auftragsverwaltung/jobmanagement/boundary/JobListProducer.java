package de.fresko.auftragsverwaltung.jobmanagement.boundary;

import de.fresko.auftragsverwaltung.companymanagement.boundary.CompanyListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.service.JobService;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.inject.Produces;
import de.fresko.auftragsverwaltung.util.Events.Added;
import de.fresko.auftragsverwaltung.util.Events.Deleted;
import de.fresko.auftragsverwaltung.util.Events.Updated;

@RequestScoped
public class JobListProducer implements Serializable {
    
    @Inject
    private JobService jobService;
    
    private List<Job> jobs = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        jobs = jobService.getAllJobs();
    }
    
    public void onJobAdded(@Observes @Added Job job){
        jobService.addJob(job);
        init();
    }
    
    public void onJobDeleted(@Observes @Deleted Job job){
        jobService.deleteJob(job);
        init();
    }
    
    public void onJobUpdated(@Observes @Updated Job job){
        jobService.updateJob(job);
        init();
    }
       
    @Named
    @Produces
    public List<Job> getJobs() {
        return jobs;
    }
}
