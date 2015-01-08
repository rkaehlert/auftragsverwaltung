package de.fresko.auftragsverwaltung.jobmanagement.boundary;

import de.fresko.auftragsverwaltung.jobmanagement.entity.Job;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class JobListTableView implements Serializable {

    private Job selectedJob;

    public JobListTableView() {
    }

    public boolean filterContainsInsensitive(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
        
        String valueText = (String)value;
        
        return valueText.toUpperCase().contains(filterText.toUpperCase());
    }

    public Job getSelectedJob() {
        return selectedJob;
    }

    public void setSelectedJob(Job selectedJob) {
        this.selectedJob = selectedJob;
    }
}
