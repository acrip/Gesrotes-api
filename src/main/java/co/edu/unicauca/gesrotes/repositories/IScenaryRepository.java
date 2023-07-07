package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Scenary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IScenaryRepository extends JpaRepository<Scenary, String> {
    List<Scenary> findAll();
}
