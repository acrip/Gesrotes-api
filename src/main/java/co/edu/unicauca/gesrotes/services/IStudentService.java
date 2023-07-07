package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Optional<List<Student>> getStudents();

    Optional<Student> getStudentById(String id);

    Optional<List<Student>> getStudentByName(String name);

    boolean addStudent(Student student);
}
