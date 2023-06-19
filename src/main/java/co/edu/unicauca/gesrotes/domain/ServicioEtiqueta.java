package co.edu.unicauca.gesrotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio_etiqueta")
public class ServicioEtiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio_etiqueta")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Etiqueta etiqueta;

    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
}
