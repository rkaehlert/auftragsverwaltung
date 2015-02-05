package de.fresko.auftragsverwaltung.usermanagement.boundary;

import de.fresko.auftragsverwaltung.companymanagement.entity.Company;
import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import de.fresko.auftragsverwaltung.usermanagement.service.FreskoUserService;
import de.fresko.auftragsverwaltung.util.Events;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
public class UserListProducer implements Serializable {
    
    @Inject
    FreskoUserService userService;
    
    private List<FreskoUser> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users = userService.getAllFreskoUsers();
    }
    
    public void onUserUpdated(@Observes @Events.Updated FreskoUser user){
        userService.updateUser(user);
        init();
    }

    @Named
    @Produces
    public List<FreskoUser> getUsers() {
        return users;
    }
}
