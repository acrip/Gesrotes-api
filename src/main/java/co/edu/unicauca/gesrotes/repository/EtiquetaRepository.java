package co.edu.unicauca.gesrotes.repository;

import co.edu.unicauca.gesrotes.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
