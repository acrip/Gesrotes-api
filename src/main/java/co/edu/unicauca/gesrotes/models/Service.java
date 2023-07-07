package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @Column(name = "id_service")
    private String idService;
    @Column(name = "name")
    private String name;

    public Service() {
    }

    public Service(String idService, String name) {
        this.idService = idService;
        this.name = name;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
