package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "coordinator")
public class Coordinator {
    @Id
    @Column(name = "id_coordinator")
    private String idCoordinator;
    private String name;
    private String idProgram;

    public Coordinator() {
    }

    public Coordinator(String idCoordinator, String name, String idProgram) {
        this.idCoordinator = idCoordinator;
        this.name = name;
        this.idProgram = idProgram;
    }

    public String getIdCoordinator() {
        return idCoordinator;
    }

    public void setIdCoordinator(String idCoordinator) {
        this.idCoordinator = idCoordinator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return idProgram;
    }

    public void setProgram(String idProgram) {
        this.idProgram = idProgram;
    }
}
