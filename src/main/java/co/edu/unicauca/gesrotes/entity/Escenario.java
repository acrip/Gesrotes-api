package co.edu.unicauca.gesrotes.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "escenario")
public class Escenario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_escenario", nullable = false, unique = true)
    private long id;
    @Column(name = "name", length = 100)
    private String name;
    @OneToMany(mappedBy = "escenario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();

    public Escenario() {
    }
    public Escenario(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Escenario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", etiquetas=" + etiquetas +
                '}';
    }
}
