package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import de.fresko.auftragsverwaltung.controller.Pages;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class TaskEditController implements Serializable {

    @Inject
    JobListController jobListController;
    @Inject
    JobViewController jobViewController;
    
    public enum Mode {
        EDIT, ADD
    };
    private Task task;
    private Mode mode;

    public Task getTask() {
        return task;
    }

    public void setTaskToEdit(Mode mode) {
        setTaskToEdit(mode, new Task());
    }
    
    public void setTaskToEdit(Mode mode, Task task) {
        this.task = task;
        this.mode = mode;
    }

    public String doSave() {
        if(mode == Mode.ADD) {
            jobViewController.getJob().getTasks().add(task);
        }
        return jobListController.doViewJob();
    }
    
    public String doCancel() {
        return Pages.JOB_LIST;
    }
    
    public String getTitle() {
        return getMode() == Mode.EDIT ? "Task bearbeiten" : "Neuen Task anlegen";
    }
    
    private Mode getMode() {
        return this.mode;
    }
}
