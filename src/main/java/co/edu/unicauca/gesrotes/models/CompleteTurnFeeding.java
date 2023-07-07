package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity
@Table(name = "turn_feeding")
public class CompleteTurnFeeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn_feeding")
    private String idTurnFeeding;
    private String nameStudent;
    @Column(name = "id_feeding")
    private String idFeeding;
    private String nameFeeding;
    @Column(name = "id_turn")
    private Integer idTurn;
    private Time startTime;
    private Time endTime;

    public CompleteTurnFeeding() {
    }

    public CompleteTurnFeeding(String idTurnFeeding, String nameStudent, String idFeeding, String nameFeeding,
            Integer idTurn, Time startTime, Time endTime) {
        this.idTurnFeeding = idTurnFeeding;
        this.nameStudent = nameStudent;
        this.idFeeding = idFeeding;
        this.nameFeeding = nameFeeding;
        this.idTurn = idTurn;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getIdTurnFeeding() {
        return idTurnFeeding;
    }

    public void setIdTurnFeeding(String idTurnFeeding) {
        this.idTurnFeeding = idTurnFeeding;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getIdFeeding() {
        return idFeeding;
    }

    public void setIdFeeding(String idFeeding) {
        this.idFeeding = idFeeding;
    }

    public String getNameFeeding() {
        return nameFeeding;
    }

    public void setNameFeeding(String nameFeeding) {
        this.nameFeeding = nameFeeding;
    }

    public Integer getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Integer idTurn) {
        this.idTurn = idTurn;
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

}
