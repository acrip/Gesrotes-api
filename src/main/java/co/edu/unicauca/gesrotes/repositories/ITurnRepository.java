package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITurnRepository extends JpaRepository<Turn, Integer> {
    @Query(value = "SELECT * FROM `turn` WHERE id_student = ?1 AND id_subject = ?2 AND id_scenary = ?3 AND id_tag = ?4 AND id_shift = ?5 AND date = ?6", nativeQuery = true)
    public Optional<Turn> findExistTurn(String idStudent, String idSubject, String idScenary, String idTag, String idShift, LocalDate date);

    @Query(value = "SELECT * FROM `turn` WHERE id_student = ?2 AND id_subject = ?1 AND date = ?3", nativeQuery = true)
    public Optional<List<Turn>> findByIdStudentAndIdSubjectAndDate(String idSubject, String idStudent, Date date);

    @Query(value = "SELECT * FROM `turn` WHERE id_subject = ?1", nativeQuery = true)
    public Optional<List<Turn>> findBySubject(String idSUbject);

    @Query(value = "SELECT * FROM `turn` WHERE id_subject = ?1 AND id_student = ?2", nativeQuery = true)
    public Optional<List<Turn>> findByStudentSubject(String idSUbject, String idStudent);

}
