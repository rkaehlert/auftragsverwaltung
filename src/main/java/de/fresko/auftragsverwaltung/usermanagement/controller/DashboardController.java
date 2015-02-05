package de.fresko.auftragsverwaltung.usermanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class DashboardController implements Serializable {

    public void DashboardController() {
    }
    
    public String doLoadDashboard() {
        return Pages.JOB_LIST;
    }
}
