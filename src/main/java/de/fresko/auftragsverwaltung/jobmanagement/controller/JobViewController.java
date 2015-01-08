package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
class JobViewController implements Serializable{

    private Job jobToView;
    
    public void setJobToView(Job job) {
        jobToView = job;
    }
    
    public Job getJob() {
        return jobToView;
    }
    
    public String getTitle() {
        return "Job: "+jobToView.getId();
    }
}
