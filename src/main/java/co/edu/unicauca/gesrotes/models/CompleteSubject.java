package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class CompleteSubject {
    @Id
    @Column(name = "id_subject")
    private String idSubject;
    @Column(name = "name")
    private String name;
    @Column(name = "id_coordinator")
    private String idCoordinator;
    @Column(name = "id_program")
    private String idProgram;
    private String nameProgram;

    public CompleteSubject() {
    }

    public CompleteSubject(String idSubject, String name, String idCoordinator, String idProgram, String nameProgram) {
        this.idSubject = idSubject;
        this.name = name;
        this.idCoordinator = idCoordinator;
        this.idProgram = idProgram;
        this.nameProgram = nameProgram;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCoordinator() {
        return idCoordinator;
    }

    public void setIdCoordinator(String idCoordinator) {
        this.idCoordinator = idCoordinator;
    }

    public String getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(String idProgram) {
        this.idProgram = idProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

}
