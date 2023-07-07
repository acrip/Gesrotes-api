package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Time;
import java.time.LocalDate;

@Entity
public class CompleteTurn {
    @Id
    @Column(name = "id_turn")
    private Integer idTurn;
    @Column(name = "id_student")
    private String idStudent;
    @Column(name = "id_subject")
    private String idSubject;
    @Column(name = "id_scenary")
    private String idScenary;
    private String nameScenary;
    @Column(name = "id_tag")
    private String idTag;
    private String nameTag;
    @Column(name = "id_shift")
    private String idShift;
    private String nameShift;
    private Time startTime;
    private Time endTime;
    private LocalDate date;

    public CompleteTurn() {
    }

    public CompleteTurn(Integer idTurn, String idStudent, String idSubject, String idScenary, String nameScenary,
            String idTag, String nameTag, String idShift, String nameShift, Time startTime, Time endTime,
            LocalDate date) {
        this.idTurn = idTurn;
        this.idStudent = idStudent;
        this.idSubject = idSubject;
        this.idScenary = idScenary;
        this.nameScenary = nameScenary;
        this.idTag = idTag;
        this.nameTag = nameTag;
        this.idShift = idShift;
        this.nameShift = nameShift;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getNameScenary() {
        return nameScenary;
    }

    public void setNameScenary(String nameScenary) {
        this.nameScenary = nameScenary;
    }

    public String getIdTag() {
        return idTag;
    }

    public void setIdTag(String idTag) {
        this.idTag = idTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String nameTag) {
        this.nameTag = nameTag;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
    }

    public String getNameShift() {
        return nameShift;
    }

    public void setNameShift(String nameShift) {
        this.nameShift = nameShift;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
