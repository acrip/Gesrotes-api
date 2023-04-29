package co.edu.unicauca.gesrotes.repository;

import co.edu.unicauca.gesrotes.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    Optional<Etiqueta> findByIdAndEnabled(Long enabled, boolean exists);

    List<Etiqueta> findAllByEnabled(boolean exists);
}
