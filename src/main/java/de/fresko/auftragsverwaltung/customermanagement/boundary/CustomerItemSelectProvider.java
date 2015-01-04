package de.fresko.auftragsverwaltung.customermanagement.boundary;

import de.fresko.auftragsverwaltung.customermanagement.entity.Customer;
import de.fresko.auftragsverwaltung.data.CustomerListProducer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class CustomerItemSelectProvider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CustomerListProducer customers;
    
    private Customer selectedCustomer;

    public ArrayList<Customer> getCustomers() {
        return customers.getCustomers();
    }
    
    public Customer getSelectedEntity() {
        return selectedCustomer;
    }

    public void setSelectedEntity(Customer selectedEntity) {
        this.selectedCustomer = selectedEntity;
    }

}