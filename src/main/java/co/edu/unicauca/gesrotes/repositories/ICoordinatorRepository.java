package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICoordinatorRepository extends JpaRepository<Coordinator, String> {
    List<Coordinator> findAll();

    Optional<Coordinator> findById(String id);

}
