package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.StudentSubject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IStudentSubjectRepository extends JpaRepository<StudentSubject, Integer> {
    @Query(value = "SELECT * FROM `student_subject` WHERE id_subject = ?1 AND id_student = ?2", nativeQuery = true)
    Optional<StudentSubject> findEnrollment(String idSubject, String idStudent);

    @Query(value = "SELECT * FROM `student_subject` WHERE id_subject = ?1", nativeQuery = true)
    Optional<List<StudentSubject>> findEnrollments(String idSubject);

    @Modifying
    @Query(value = "DELETE FROM student_subject WHERE id_subject = ?1 AND id_student = ?2", nativeQuery = true)
    void deleteEnrollment(String idSubject, String idStudent);

    @Modifying
    @Query(value = "DELETE FROM student_subject WHERE id_subject = ?1", nativeQuery = true)
    void deleteEnrollments(String idSubject);

}
