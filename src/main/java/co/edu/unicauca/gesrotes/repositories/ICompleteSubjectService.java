package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICompleteSubjectService extends JpaRepository<CompleteSubject, String> {
    @Query(value = "SELECT s.id_subject, s.name, s.id_coordinator, s.id_program, p.name name_program FROM subject s JOIN program p ON s.id_program=p.id_program", nativeQuery = true)
    Optional<List<CompleteSubject>> findAllSubjects();

    @Query(value = "SELECT s.id_subject, s.name, s.id_coordinator, s.id_program, p.name name_program FROM subject s JOIN program p ON s.id_program=p.id_program WHERE s.name LIKE %?1%", nativeQuery = true)
    Optional<List<CompleteSubject>> findByName(String name);

    @Query(value = "SELECT s.id_subject, s.name, s.id_coordinator, s.id_program, p.name name_program FROM subject s JOIN program p ON s.id_program=p.id_program WHERE s.id_coordinator = ?1", nativeQuery = true)
    List<CompleteSubject> findSubjectsToCoordinator(String id);

    @Query(value = "SELECT s.id_subject, s.name, s.id_coordinator, s.id_program, p.name name_program FROM subject s JOIN program p ON s.id_program=p.id_program WHERE s.id_subject = ?1", nativeQuery = true)
    Optional<CompleteSubject> findById(String id);
}
