package de.fresko.auftragsverwaltung.jobmanagement.entity;

public enum EnumDeliveryTypes {

    ANLIEFERUNG("Anlieferung"),
    ABHOLUNG("Abholung"),
    VERSAND("Versand"),
    MONTAGE("Montage"),
    NA("nicht angegeben"),
    NOTE("siehe Notizen");

    private String description = "";

    private EnumDeliveryTypes(String value) {
        this.description = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}
