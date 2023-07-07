package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scenary")
public class Scenary {
    @Id
    @Column(name= "id_scenary")
    private String idScenary;
    private String name;
    private String address;

    public Scenary() {
    }

    public Scenary(String idScenary, String name, String address) {
        this.idScenary = idScenary;
        this.name = name;
        this.address = address;
    }

    public String getIdScenary() {
        return idScenary;
    }

    public void setIdScenary(String idScenary) {
        this.idScenary = idScenary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
