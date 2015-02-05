package de.fresko.auftragsverwaltung.usermanagement.service;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
public class MockUserServiceBean {
    private void createMockJobs() {
        FreskoUser user1 = new FreskoUser();
        user1.setId(12345L);
        user1.setFirstname("Robin");
        user1.setLastname("Kählert");
        
        FreskoUser user2 = new FreskoUser();
        user2.setId(67890L);
        user2.setFirstname("Michael");
        user2.setLastname("Frank");
        
        List<FreskoUser> users = new ArrayList<>();
        users.add(user2);
        users.add(user1);
    }
}
