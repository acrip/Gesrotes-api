package co.edu.unicauca.gesrotes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turn_feeding")
public class TurnFeeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn_feeding")
    private String idTurnFeeding;
    @Column(name = "id_feeding")
    private String idFeeding;
    @Column(name = "id_turn")
    private Integer idTurn;

    public TurnFeeding() {
    }

    public TurnFeeding(String idFeeding, Integer idTurn) {
        this.idFeeding = idFeeding;
        this.idTurn = idTurn;
    }

    public TurnFeeding(String idTurnFeeding, String idFeeding, Integer idTurn) {
        this.idTurnFeeding = idTurnFeeding;
        this.idFeeding = idFeeding;
        this.idTurn = idTurn;
    }

    public String getIdTurnFeeding() {
        return idTurnFeeding;
    }

    public void setIdTurnFeeding(String idTurnFeeding) {
        this.idTurnFeeding = idTurnFeeding;
    }

    public String getIdFeeding() {
        return idFeeding;
    }

    public void setIdFeeding(String idFeeding) {
        this.idFeeding = idFeeding;
    }

    public Integer getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(Integer idTurn) {
        this.idTurn = idTurn;
    }

}
