package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "validation")
public class Validation {
    @Id
    @Column(name = "id_validation")
    private String idValidation;
    @Column(name = "id_student")
    private String idStudent;
    @Column(name = "id_subject")
    private String idSubject;
    private Date date;
    private String state;
    private String comment;

    public Validation() {
    }

    public Validation(String idStudent, String idSubject, Date date, String state) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.date = date;
        this.state = state;
        this.comment = "";
    }

    public Validation(String idValidation, String idStudent, String idSubject, Date date, String state,
            String comment) {
        this.idValidation = idValidation;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.date = date;
        this.state = state;
        this.comment = comment;
    }

    public String getIdValidation() {
        return idValidation;
    }

    public void setIdValidation(String idValidation) {
        this.idValidation = idValidation;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
