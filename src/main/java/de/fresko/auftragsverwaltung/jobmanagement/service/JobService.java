package de.fresko.auftragsverwaltung.jobmanagement.service;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(Job job);
}
