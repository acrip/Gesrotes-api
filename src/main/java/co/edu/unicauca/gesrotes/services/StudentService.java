package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.Student;
import co.edu.unicauca.gesrotes.repositories.IStudentRepository;
import co.edu.unicauca.gesrotes.utilities.codegodsUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository students;

    @Override
    public Optional<List<Student>> getStudents() {
        return students.findAllStudents();
    }

    @Override
    public Optional<Student> getStudentById(String id) {
        return students.findById(id);
    }

    @Override
    public Optional<List<Student>> getStudentByName(String name) {
        name = codegodsUtilities.plainString(name);
        return students.findByName(name);
    }

    @Override
    public boolean addStudent(Student student) {
        if (getStudentById(student.getIdStudent()).isPresent()) {
            return false;
        }
        students.save(student);
        return true;
    }

}
