package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "student")
public class Student {
  @Id
  @Column(name = "id_student")
  private String idStudent;
  @Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "id_program")
  private String idProgram;

  public Student() {
  }

  public Student(String idStudent, String code, String name, String idProgram) {
    this.idStudent = idStudent;
    this.code = code;
    this.name = name;
    this.idProgram = idProgram;
  }

  public String getIdStudent() {
    return idStudent;
  }

  public void setIdStudent(String idStudent) {
    this.idStudent = idStudent;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdProgram() {
    return idProgram;
  }

  public void setIdProgram(String idProgram) {
    this.idProgram = idProgram;
  }

}
