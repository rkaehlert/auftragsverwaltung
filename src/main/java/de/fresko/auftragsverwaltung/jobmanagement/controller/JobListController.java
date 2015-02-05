package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import de.fresko.auftragsverwaltung.util.Events.Deleted;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class JobListController implements Serializable {

    @Inject @Deleted
    private Event<Job> jobDeleteEventSrc;
    
    @Inject
    private JobEditController jobEditController;

    @Inject
    private JobViewController jobViewController;

    private Job jobToDelete;
    
    public String doListJobs() {
        return Pages.JOB_LIST;
    }

    public String doAddJob() {
        jobEditController.setJobToEdit(JobEditController.Mode.ADD);
        return Pages.JOB_EDIT;
    }

    public String doEditJob(Job job) {
        jobEditController.setJobToEdit(JobEditController.Mode.EDIT, job);
        return Pages.JOB_EDIT;
    }

    public String doViewJob() {
        return Pages.JOB_VIEW;
    }

    public String doViewJob(Job job) {
        jobViewController.setJobToView(job);
        return Pages.JOB_VIEW;
    }

    public void commitDeleteJob() {
        jobDeleteEventSrc.fire(jobToDelete);
    }
    
    public void doDeleteJob(Job job) {
        jobToDelete = job;
    }

    public String getAllTasks(Job job) {
        String returnValue = "";

        for (Task t : job.getTasks()) {
            returnValue += t.getDescription() + ";";
        }

        return returnValue;
    }

    public String getAllArrangers(Job job) {
        String returnValue = "";

        for (FreskoUser u : job.getArranger()) {
            returnValue += u.getFirstname() + " " + u.getLastname() + ";";
        }

        return returnValue;
    }
}
