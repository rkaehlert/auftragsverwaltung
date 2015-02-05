package de.fresko.auftragsverwaltung.jobmanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Task;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
class JobViewController implements Serializable{

    @Inject
    TaskEditController taskEditController;
    
    private Job jobToView;
    
    public void setJobToView(Job job) {
        jobToView = job;
    }
    
    public Job getJob() {
        return jobToView;
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
        return "Job: "+jobToView.getId();
    }
}
