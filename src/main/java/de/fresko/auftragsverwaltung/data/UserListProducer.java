package de.fresko.auftragsverwaltung.data;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class UserListProducer implements Serializable {
    private ArrayList<FreskoUser> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        createMockJobs();
    }

    public ArrayList<FreskoUser> getUsers() {
        return users;
    }
    
    private void createMockJobs() {
        FreskoUser user1 = new FreskoUser();
        user1.setId(12345L);
        user1.setFirstname("Robin");
        user1.setLastname("Kählert");
        
        FreskoUser user2 = new FreskoUser();
        user2.setId(67890L);
        user2.setFirstname("Michael");
        user2.setLastname("Frank");
        
        users.add(user2);
        users.add(user1);
    }
}
