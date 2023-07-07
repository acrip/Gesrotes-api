package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ISubjectRepository extends JpaRepository<Subject, String> {
    @Query(value = "SELECT * FROM subject", nativeQuery = true)
    Optional<List<Subject>> findAllSubjects();

    @Query(value = "SELECT * FROM subject WHERE name LIKE %?1%", nativeQuery = true)
    Optional<List<Subject>> findByName(String name);

    @Query(value = "SELECT * FROM subject WHERE id_coordinator = ?1", nativeQuery = true)
    List<Subject> findSubjectsToCoordinator(String id);
}
