package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IValidationRepository extends JpaRepository<Validation, Integer> {
    @Query(value = "SELECT v.*, s.name FROM validation v JOIN student s ON v.id_student = s.id_student WHERE v.id_subject = ?1 AND MONTH(v.date) = MONTH(?2) AND YEAR(v.date) = YEAR(?2)", nativeQuery = true)
    Optional<List<Validation>> findValidationsToDate(String idSubject, Date date);
}
