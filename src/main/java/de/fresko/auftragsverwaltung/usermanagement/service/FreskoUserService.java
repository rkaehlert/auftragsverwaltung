package de.fresko.auftragsverwaltung.usermanagement.service;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import de.fresko.auftragsverwaltung.util.Events;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class FreskoUserService {

    @Inject
    EntityManager em;

    public List<FreskoUser> getAllFreskoUsers() {
        return em.createNamedQuery(FreskoUser.FIND_ALL, FreskoUser.class).getResultList();
    }

    public FreskoUser findUserById(Long id) {
        return em.find(FreskoUser.class, id);
    }

    public FreskoUser updateUser(@Observes @Events.Updated FreskoUser user) {
        user = em.merge(user);
        return user;
    }

    public FreskoUser loginUser(String email, String password) {
        List<FreskoUser> users = em.createNamedQuery(FreskoUser.FIND_BY_USERNAME, FreskoUser.class)
                .setParameter(FreskoUser.PARAM_USERNAME, email)
                .getResultList();

        if (users.isEmpty()) {
            System.out.println("no user");
            return null;
        }

        FreskoUser user = users.get(0);

        if (!user.checkPassword(password)) {
            System.out.println("wrong pw");
            return null;
        }

        user.setLastLogin(new Date());

        return user;
    }
}
