package de.fresko.auftragsverwaltung.jobmanagement.service;

import de.fresko.auftragsverwaltung.companymanagement.boundary.CompanyListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.EnumDeliveryTypes;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@RequestScoped
@Alternative
public class MockJobServiceBean implements JobService {

    @Inject
    CompanyListProducer clp;
    
    @Override
    public List<Job> getAllJobs() {
        Task t1 = new Task();
        t1.setId(1L);
        t1.setNeededTime(534);
        t1.setDateFinished(new Date(2014, 1, 8));
        t1.setDescription("Task 1");
        Task t2 = new Task();
        t2.setNeededTime(871);
        t2.setDateFinished(new Date(2015, 1, 1));
        t2.setId(2L);
        t2.setDescription("Task 2");
        Task t3 = new Task();
        t3.setNeededTime(1);
        t3.setDateFinished(new Date(2014, 12, 31));
        t3.setId(3L);
        t3.setDescription("Task 3");
        Task t4 = new Task();
        t4.setId(4L);
        t4.setDateFinished(new Date(2015, 1, 5));
        t4.setNeededTime(340);
        t4.setDescription("Task 4");

        Job job1 = new Job();
        job1.setId("2015-01-000");
        job1.setDescription("Job1");
        job1.setDelivery(EnumDeliveryTypes.ABHOLUNG);
        job1.setNote("nicht dringend");
        job1.setCustomer(clp.getCustomers().get(0));
        job1.addTask(t1);
        job1.addTask(t2);

        Job job2 = new Job();
        job2.setId("2015-01-001");
        job2.setDescription("Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2Job2");
        job2.setDelivery(EnumDeliveryTypes.NOTE);
        job2.setNote("wird per Flugzeug verschickt");
        job2.setCustomer(clp.getCustomers().get(1));
        job2.addTask(t4);
        job2.addTask(t3);

        List<Job> jobs = new ArrayList<>();
        jobs.add(job1);
        jobs.add(job2);
        
        return jobs;
    }

    @Override
    public void addJob(Job job) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateJob(Job job) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteJob(Job job) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
