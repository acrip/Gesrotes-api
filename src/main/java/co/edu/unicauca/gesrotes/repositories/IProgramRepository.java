package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProgramRepository extends JpaRepository<Program, String> {
    List<Program> findAll();
}
