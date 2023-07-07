package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "turn")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Integer idTurn;
    @Column(name = "id_student")
    private String idStudent;
    @Column(name = "id_subject")
    private String idSubject;
    @Column(name = "id_scenary")
    private String idScenary;
    @Column(name = "id_tag")
    private String idTag;
    @Column(name = "id_shift")
    private String idShift;
    private LocalDate date;

    public Turn() {
    }

    public Turn(String idStudent, String idSubject, String idScenary, String idTag, String idShift,
            LocalDate date) {
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.idScenary = idScenary;
        this.idTag = idTag;
        this.idShift = idShift;
        this.date = date;
    }

    public Turn(Integer idTurn, String idStudent, String idSubject, String idScenary, String idTag, String idShift,
            LocalDate date) {
        this.idTurn = idTurn;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.idScenary = idScenary;
        this.idTag = idTag;
        this.idShift = idShift;
        this.date = date;
    }

    public Integer getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Integer idTurn) {
        this.idTurn = idTurn;
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

    public String getIdScenary() {
        return idScenary;
    }

    public void setIdScenary(String idScenary) {
        this.idScenary = idScenary;
    }

    public String getIdTag() {
        return idTag;
    }

    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
