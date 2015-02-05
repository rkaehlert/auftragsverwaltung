package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.jobmanagement.boundary.JobListProducer;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import de.fresko.auftragsverwaltung.util.Events.Added;
import de.fresko.auftragsverwaltung.util.Events.Updated;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class JobEditController implements Serializable {

    @Inject @Added
    private Event<Job> jobAddEventSrc;
    
    @Inject @Updated
    private Event<Job> jobUpdateEventSrc;
    
    @Inject
    private TaskEditController taskEditController;

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
            jobAddEventSrc.fire(job);
        }
        else if(getMode() == Mode.EDIT) {
            jobUpdateEventSrc.fire(job);
        }
        return Pages.JOB_LIST;
    }

    public String doCancel() {
        return Pages.JOB_LIST;
    }

    public String doEditTask(Task task) {
        taskEditController.setTaskToEdit(TaskEditController.Mode.EDIT, task);
        return Pages.TASK_EDIT;
    }

    public String doAddTask() {
        taskEditController.setTaskToEdit(TaskEditController.Mode.ADD);
        return Pages.TASK_EDIT;
    }

    public String getTitle() {
        return getMode() == Mode.EDIT ? "Job bearbeiten" : "Neuen Job anlegen";
    }

    private Mode getMode() {
        return this.mode;
    }
}
