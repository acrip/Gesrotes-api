package co.edu.unicauca.gesrotes.services;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import co.edu.unicauca.gesrotes.models.Student;
import co.edu.unicauca.gesrotes.models.StudentSubject;
import co.edu.unicauca.gesrotes.repositories.ICompleteSubjectService;
import co.edu.unicauca.gesrotes.repositories.IStudentRepository;
import co.edu.unicauca.gesrotes.repositories.IStudentSubjectRepository;
import co.edu.unicauca.gesrotes.repositories.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    ISubjectRepository subjectRepository;
    @Autowired
    ICompleteSubjectService completeSubjectService;
    @Autowired
    IStudentRepository studentRepository;
    @Autowired
    IStudentSubjectRepository studentSubjectRepository;

    @Override
    public Optional<List<CompleteSubject>> getAll() {
        return completeSubjectService.findAllSubjects();
    }

    @Override
    public Optional<List<Student>> getAllStudents(String id) {
        return studentRepository.findStudentsToSubject(id);
    }

    @Override
    public Optional<List<Student>> getStudentsByName(String idSubject, String nameStudent) {
        return studentRepository.findStudentsToSubjectByName(idSubject, nameStudent);
    }

    @Override
    public Optional<Student> getStudent(String idSubject, String idStudent) {
        return studentRepository.findStudentToSubject(idSubject, idStudent);
    }

    @Override
    public Optional<CompleteSubject> getById(String id) {
        return completeSubjectService.findById(id);
    }

    @Override
    public Optional<List<CompleteSubject>> getByName(String name) {
        return completeSubjectService.findByName(name);
    }

    @Override
    public Integer addStudentToSubject(StudentSubject studentSubject) {
        try {
            if (getStudent(studentSubject.getIdSubject(), studentSubject.getIdStudent()).isPresent()) {
                return 0;
            }
            studentSubjectRepository.save(studentSubject);
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Integer deleteStudentToSubject(String idSubject, String idStudent) {
        Optional<StudentSubject> studentSubject = studentSubjectRepository.findEnrollment(idSubject, idStudent);

        if (studentSubject.isPresent()) {
            studentSubjectRepository.deleteEnrollment(idSubject, idStudent);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer deleteStudentsToSubject(String idSubject) {
        Optional<List<StudentSubject>> studentSubject = studentSubjectRepository.findEnrollments(idSubject);

        if (studentSubject.isPresent()) {
            if (!studentSubject.get().isEmpty()) {
                studentSubjectRepository.deleteEnrollments(idSubject);
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }

    @Override
    public Optional<List<Student>> getAllNotStudents(String id) {
        return studentRepository.findAllNotStudents(id);
    }

    @Override
    public Optional<List<Student>> getNotStudentsByName(String idSubject, String nameStudent) {
        return studentRepository.findNotStudentsToSubjectByName(idSubject, nameStudent);
    }


}
