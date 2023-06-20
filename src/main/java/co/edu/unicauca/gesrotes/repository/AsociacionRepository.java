package co.edu.unicauca.gesrotes.repository;

import co.edu.unicauca.gesrotes.domain.Asociacion;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsociacionRepository extends ListCrudRepository<Asociacion, Long> {
}
