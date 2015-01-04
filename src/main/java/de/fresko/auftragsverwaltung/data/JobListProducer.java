package de.fresko.auftragsverwaltung.data;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class JobListProducer implements Serializable {
    private ArrayList<Job> jobs = new ArrayList<>();

    @PostConstruct
    public void init() {
        createMockJobs();
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }
    
    private void createMockJobs() {
        Job job1 = new Job();
        job1.setJobID("job-123");
        job1.setDescription("Job1");
        job1.setContact("012345678");
        job1.setDelivery("Hand");
        job1.setNote("zu leicht");
        
        Job job2 = new Job();
        job2.setJobID("job-456");
        job2.setDescription("Test Job2");
        job2.setContact("098765432");
        job2.setDelivery("auto");
        job2.setNote("nichterfüllbar");
        jobs.add(job1);
        jobs.add(job2);
    }
}
