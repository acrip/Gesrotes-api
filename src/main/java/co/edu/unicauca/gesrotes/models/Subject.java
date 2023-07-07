package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {
  @Id
  @Column(name = "id_subject")
  private String idSubject;
  @Column(name = "name")
  private String name;
  @Column(name = "id_coordinator")
  private String idCoordinator;
  @Column(name = "id_program")
  private String idProgram;

  public Subject() {
  }

  public Subject(String idSubject, String name, String idCoordinator, String idProgram) {
    this.idSubject = idSubject;
    this.name = name;
    this.idCoordinator = idCoordinator;
    this.idProgram = idProgram;
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

}
