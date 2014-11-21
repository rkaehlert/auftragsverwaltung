package de.fresko.auftragsverwaltung.auftragsverwaltung.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class ListJobsController implements Serializable {

    public String doAddJob() {
        return Pages.EDIT_JOB;
    }
}
