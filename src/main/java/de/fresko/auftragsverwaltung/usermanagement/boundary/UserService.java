package de.fresko.auftragsverwaltung.usermanagement.boundary;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService {

    @PersistenceContext
    EntityManager em;

    public List<FreskoUser> getAllFreskoUsers() {
        return em.createNamedQuery(FreskoUser.FIND_ALL, FreskoUser.class).getResultList();
    }

    public FreskoUser findUserById(Long id) {
        return em.find(FreskoUser.class, id);
    }

    public FreskoUser updateUser(FreskoUser user) {
        if (user.getId() == null)
            em.persist(user);
        else
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
