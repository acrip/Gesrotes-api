package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.CompleteTurn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICompleteTurnRepository extends JpaRepository<CompleteTurn, Integer> {
    @Query(value = "SELECT t.id_turn, t.id_student, t.id_subject, t.id_scenary, s.name name_scenary, t.id_tag, tag.name name_tag, t.id_shift, shift.shift_type name_shift, shift.start_time, shift.end_time, t.date FROM `turn` t JOIN scenary s ON t.id_scenary = s.id_scenary JOIN tag ON tag.id_tag = t.id_tag JOIN shift ON shift.id_shift = t.id_shift WHERE id_subject = ?1", nativeQuery = true)
    public Optional<List<CompleteTurn>> findCompleteBySubject(String idSubject);

    @Query(value = "SELECT t.id_turn, t.id_student, t.id_subject, t.id_scenary, s.name name_scenary, t.id_tag, tag.name name_tag, t.id_shift, shift.shift_type name_shift, shift.start_time, shift.end_time, t.date FROM `turn` t JOIN scenary s ON t.id_scenary = s.id_scenary JOIN tag ON tag.id_tag = t.id_tag JOIN shift ON shift.id_shift = t.id_shift WHERE id_subject = ?1 AND id_student = ?2", nativeQuery = true)
    public Optional<List<CompleteTurn>> findByStudentSubject(String idSUbject, String idStudent);
}
