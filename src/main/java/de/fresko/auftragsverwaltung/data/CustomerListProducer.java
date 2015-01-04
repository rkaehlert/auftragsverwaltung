package de.fresko.auftragsverwaltung.data;

import de.fresko.auftragsverwaltung.customermanagement.entity.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class CustomerListProducer implements Serializable{

    private ArrayList<Customer> customers = new ArrayList<>();

    @PostConstruct
    public void init() {
        createMockCustomers();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private void createMockCustomers() {
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("Bad Blau");
        c1.setZip("12345");

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setName("Würzburg Vegan");
        c2.setTown("Würzburg");

        customers.add(c1);
        customers.add(c2);
    }
}
