package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_subject")
public class StudentSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student_subject")
    private Integer idStudentSubject;
    @Column(name = "id_student")
    private String idStudent;
    @Column(name = "id_subject")
    private String idSubject;

    public StudentSubject() {
    }

    public StudentSubject(Integer idStudentSubject, String idStudent, String idSubject) {
        this.idStudentSubject = idStudentSubject;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
    }

    public Integer getIdStudentSubject() {
        return idStudentSubject;
    }

    public void setIdStudentSubject(Integer idStudentSubject) {
        this.idStudentSubject = idStudentSubject;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }
}
