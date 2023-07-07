package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "feeding")
public class Feeding {
    @Id
    @Column(name = "id_feeding")
    private String idFeeding;
    private String name;

    public Feeding() {
    }

    public Feeding(String idFeeding, String name) {
        this.idFeeding = idFeeding;
        this.name = name;
    }

    public String getIdFeeding() {
        return idFeeding;
    }

    public void setIdFeeding(String idFeeding) {
        this.idFeeding = idFeeding;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
