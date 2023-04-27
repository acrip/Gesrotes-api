package co.edu.unicauca.gesrotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "etiqueta")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etqueta", nullable = false, unique = true)
    private long id;
    @Column(name = "name", length = 100)
    private String name;
    @ManyToOne
    private Escenario escenario;

    public Etiqueta() {
    }
    public Etiqueta(String name, Escenario escenario) {
        this.name = name;
        this.escenario = escenario;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", escenario=" + escenario +
                '}';
    }
}
