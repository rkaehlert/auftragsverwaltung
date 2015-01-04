package de.fresko.auftragsverwaltung.usermanagement.boundary;

import de.fresko.auftragsverwaltung.data.UserListProducer;
import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class UserItemSelectProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserListProducer users;
    private List<FreskoUser> selectedEntity;

    public ArrayList<FreskoUser> getUsers() {
        return users.getUsers();
    }
    
    public List<FreskoUser> getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(List<FreskoUser> selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

}