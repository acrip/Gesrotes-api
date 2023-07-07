package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity
@Table(name = "shift")
public class Shift {
    @Id
    @Column(name = "id_shift")
    private String idShift;
    private Time startTime;
    private Time endTime;
    private String shiftType;

    public Shift() {
    }

    public Shift(String shiftType) {
        this.shiftType = shiftType;
    }

    public Shift(String idShift, Time startTime, Time endTime, String shiftType) {
        this.idShift = idShift;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shiftType = shiftType;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String idShift) {
        this.idShift = idShift;
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

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }
}
