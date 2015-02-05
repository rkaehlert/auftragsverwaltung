package de.fresko.auftragsverwaltung.jobmanagement.boundary;

import de.fresko.auftragsverwaltung.jobmanagement.entity.EnumDeliveryTypes;
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
        for (EnumDeliveryTypes delivery : EnumDeliveryTypes.values()) {
            deliveries.add(new SelectItem(delivery.name(), delivery.getDescription()));
        }
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
