package de.fresko.auftragsverwaltung.jobmanagement.boundary;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@Stateless
public class DeliveryItemSelectProvider {

    private ArrayList<SelectItem> deliveries = new ArrayList<>();
    private String selected;
    
    @PostConstruct
    private void init() {
        deliveries.add(new SelectItem("Anlieferung", "Anlieferung"));
        deliveries.add(new SelectItem("Abholung", "Abholung"));
        deliveries.add(new SelectItem("Versand","Versand"));
        deliveries.add(new SelectItem("Montage","Montage"));
        deliveries.add(new SelectItem("nicht bekannt","nicht bekannt"));
        deliveries.add(new SelectItem("siehe Besonderheiten","siehe Besonderheiten"));
    }

    public String getSelected() {
        return selected;
    }
    
    public ArrayList<SelectItem> getDeliveries() {
        return deliveries;
    }
    
    public void setSelected(String selection) {
        this.selected = selection;
    }
}
