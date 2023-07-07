package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import co.edu.unicauca.gesrotes.models.Student;
import co.edu.unicauca.gesrotes.models.StudentSubject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    Optional<List<CompleteSubject>> getAll();

    Optional<CompleteSubject> getById(String id);

    Optional<List<CompleteSubject>> getByName(String name);

    Optional<List<Student>> getAllStudents(String id);

    Optional<List<Student>> getStudentsByName(String idSubject, String nameStudent);

    Optional<Student> getStudent(String idSubject, String idStudent);

    Optional<List<Student>> getAllNotStudents(String id);

    Optional<List<Student>> getNotStudentsByName(String idSubject, String nameStudent);

    Integer addStudentToSubject(StudentSubject student);

    Integer deleteStudentToSubject(String idSubject, String idStudent);

    Integer deleteStudentsToSubject(String idSubject);
}
