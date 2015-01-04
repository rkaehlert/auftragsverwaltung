package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.data.JobListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class JobEditController implements Serializable {

    @Inject
    private JobListProducer jobListProducer;
    public enum Mode {
        EDIT, ADD
    };
    private Job job;
    private Mode mode;

    public Job getJob() {
        return job;
    }

    public void setJobToEdit(Mode mode) {
        setJobToEdit(mode, new Job());
    }

    public void setJobToEdit(Mode mode, Job job) {
        this.job = job;
        this.mode = mode;
    }

    public String doSave() {
        if (getMode() == Mode.ADD) {
            jobListProducer.getJobs().add(job);
        }
        return Pages.JOB_LIST;
    }
    
    public String doCancel() {
        return Pages.JOB_LIST;
    }
    
    public String getTitle() {
        return getMode() == Mode.EDIT ? "Job bearbeiten" : "Neuen Job anlegen";
    }
    
    private Mode getMode() {
        return this.mode;
    }
}
