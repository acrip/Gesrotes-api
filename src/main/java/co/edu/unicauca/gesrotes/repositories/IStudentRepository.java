package co.edu.unicauca.gesrotes.repositories;

import co.edu.unicauca.gesrotes.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT * FROM student", nativeQuery = true)
    public Optional<List<Student>> findAllStudents();

    @Query(value = "SELECT * FROM student WHERE name LIKE %?1%", nativeQuery = true)
    Optional<List<Student>> findByName(String name);

    @Query(value = "SELECT s.id_student, s.code, s.name, s.id_program FROM `student_subject` ss INNER JOIN student s ON ss.id_student = s.id_student WHERE ss.id_subject = ?1", nativeQuery = true)
    public Optional<List<Student>> findStudentsToSubject(String id);

    @Query(value = "SELECT s.id_student, s.code, s.name, s.id_program FROM `student_subject` ss INNER JOIN student s ON ss.id_student = s.id_student WHERE ss.id_subject = ?1 AND ss.id_student = ?2", nativeQuery = true)
    public Optional<Student> findStudentToSubject(String iSubject, String idStudent);

    @Query(value = "SELECT s.id_student, s.code, s.name, s.id_program FROM `student_subject` ss INNER JOIN student s ON ss.id_student = s.id_student WHERE ss.id_subject = ?1 AND s.name LIKE %?2%", nativeQuery = true)
    public Optional<List<Student>> findStudentsToSubjectByName(String iSubject, String nameStudent);

    @Query(value = "SELECT * FROM student WHERE id_student NOT IN (SELECT id_student FROM student_subject WHERE id_subject = ?1)", nativeQuery = true)
    public Optional<List<Student>> findAllNotStudents(String idSubject);

    @Query(value = "SELECT * FROM student WHERE id_student NOT IN (SELECT id_student FROM student_subject WHERE id_subject = ?1) AND name LIKE %?2%", nativeQuery = true)
    public Optional<List<Student>> findNotStudentsToSubjectByName(String iSubject, String nameStudent);
}
