package de.fresko.auftragsverwaltung.usermanagement.boundary;

import de.fresko.auftragsverwaltung.usermanagement.entity.FreskoUser;
import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class UserItemSelectProvider implements Serializable {

    private List<FreskoUser> selectedEntities;

    public List<FreskoUser> getSelectedEntity() {
        return selectedEntities;
    }

    public void setSelectedEntity(List<FreskoUser> selectedEntity) {
        this.selectedEntities = selectedEntity;
    }

}