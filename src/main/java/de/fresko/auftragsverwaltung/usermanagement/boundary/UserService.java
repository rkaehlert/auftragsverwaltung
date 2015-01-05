package de.fresko.auftragsverwaltung.usermanagement.boundary;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
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
        List<FreskoUser> users = em.createNamedQuery(FreskoUser.FIND_BY_EMAIL, FreskoUser.class)
                .setParameter(FreskoUser.PARAM_EMAIL, email)
                .getResultList();

        if (users.isEmpty())
            return null;
        
        FreskoUser user = users.get(0);

        if (!user.checkPassword(password))
            return null;

        user.setLastLogin(new Date());

        return user;
    }
}
