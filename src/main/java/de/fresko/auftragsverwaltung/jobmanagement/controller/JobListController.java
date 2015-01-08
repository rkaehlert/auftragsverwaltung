package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class JobListController implements Serializable {

    @Inject
    private JobEditController jobEditController;
    
    @Inject JobViewController jobViewController;
    
    public String doAddJob() {
        jobEditController.setJobToEdit(JobEditController.Mode.ADD);
        return Pages.JOB_EDIT;
    }
    
    public String doEditJob(Job job) {
        jobEditController.setJobToEdit(JobEditController.Mode.EDIT, job);
        return Pages.JOB_EDIT;
    }
    
    public String doViewJob(Job job) {
        jobViewController.setJobToView(job);
        return Pages.JOB_VIEW;
    }
    
    public String doDeleteJob(Job job) {
        return Pages.JOB_DELETE;
    }
    
    public String getAllTasks(Job job) {
        String returnValue = "";
        
        for(Task t : job.getTasks()) {
            returnValue += t.getDescription()+";";
        }
        
        return returnValue;
    }
}