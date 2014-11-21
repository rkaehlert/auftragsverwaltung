package de.fresko.auftragsverwaltung.data;

import de.fresko.auftragsverwaltung.auftragsverwaltung.entity.Auftrag;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@ManagedBean
public class JobListProducer implements Serializable {
    private List<Auftrag> jobs;

    @PostConstruct
    public void init() {
        createMockJobs();
    }

    public List<Auftrag> getJobs() {
        return jobs;
    }
    
    private void createMockJobs() {
        Auftrag job1 = new Auftrag();
        job1.setBeschreibung("Test Job1");
        job1.setKontakt("012345678");
        job1.setLieferart("Hand");
        job1.setBesonderheiten("zu leicht");
        
        Auftrag job2 = new Auftrag();
        job2.setBeschreibung("Test Job2");
        job2.setKontakt("098765432");
        job2.setLieferart("auto");
        job2.setBesonderheiten("nichterfüllbar");
        jobs.add(job1);
        jobs.add(job2);
    }
}
