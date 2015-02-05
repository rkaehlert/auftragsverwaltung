package de.fresko.auftragsverwaltung.usermanagement.controller;

import de.fresko.auftragsverwaltung.controller.Pages;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import de.fresko.auftragsverwaltung.util.Events.Updated;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class UserEditController implements Serializable {

    @Inject @Updated
    private Event<FreskoUser> userUpdateEventSrc;

    @Inject
    LoginController lc;
    
    public String doSave() {
        userUpdateEventSrc.fire(lc.loggedInUser());
        return Pages.JOB_LIST;
    }

    public String doCancel() {
        return Pages.JOB_LIST;
    }

    public String getTitle() {
        return "User bearbeiten";
    }
}
