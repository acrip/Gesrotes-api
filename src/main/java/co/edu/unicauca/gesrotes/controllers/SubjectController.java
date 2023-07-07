package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.CompleteSubject;
import co.edu.unicauca.gesrotes.models.Student;

import co.edu.unicauca.gesrotes.models.StudentSubject;
import co.edu.unicauca.gesrotes.services.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;

    @GetMapping
    public ResponseEntity<?> subjects(@RequestParam(required = false) String id,
                                      @RequestParam(required = false) String name) {
        Optional<CompleteSubject> subject = Optional.empty();
        Optional<List<CompleteSubject>> subjects = Optional.empty();
        if (id != null) {
            subject = subjectService.getById(id);
        } else if (name != null) {
            subjects = subjectService.getByName(name);
        } else {
            subjects = subjectService.getAll();
        }

        if (subject.isPresent()) {
            return ResponseEntity.ok(subject);
        } else if (subjects.isPresent()) {
            return ResponseEntity.ok(subjects);
        } else {
            return ResponseEntity.status(404).body("Error en la consulta");
        }
    }

    @GetMapping("/students")
    public ResponseEntity<?> students(@RequestParam(required = true) String idSubject, @RequestParam(required = false) String idStudent, @RequestParam(required = false) String nameStudent) {
        Optional<List<Student>> students = Optional.empty();
        Optional<Student> student = Optional.empty();
        if (idStudent == null && nameStudent == null) {
            students = subjectService.getAllStudents(idSubject);
        } else if (nameStudent == null) {
            student = subjectService.getStudent(idSubject, idStudent);
        } else {
            students = subjectService.getStudentsByName(idSubject, nameStudent);
        }

        if (students.isPresent()) {
            return ResponseEntity.ok(students);
        } else if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(404).body("No se encontró ningun resultado");
        }
    }

    @GetMapping("/notStudents")
    public ResponseEntity<?> notStudents(@RequestParam(required = true) String idSubject, @RequestParam(required = false) String nameStudent) {
        Optional<List<Student>> students = Optional.empty();
        Optional<Student> student = Optional.empty();
        if (nameStudent == null) {
            students = subjectService.getAllNotStudents(idSubject);
        } else {
            students = subjectService.getNotStudentsByName(idSubject, nameStudent);
        }

        if (students.isPresent()) {
            return ResponseEntity.ok(students);
        } else if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(404).body("No se encontró ningun resultado");
        }
    }

    @PostMapping("/students/add")
    public ResponseEntity<?> addStudentToSubject(@RequestParam(required = true) String idSubject,
                                                 @RequestParam(required = true) String idStudent) {
        StudentSubject studentSubject = new StudentSubject(null, idStudent, idSubject);
        Integer response = subjectService.addStudentToSubject(studentSubject);
        if (response == 1) {
            return ResponseEntity.ok("Agregado exitosamente");
        } else if (response == 0) {
            return ResponseEntity.status(400).body("El estudiante ya existe");
        } else {
            return ResponseEntity.status(400).body("Revise los campos a enviar");
        }
    }

    @GetMapping("/students/delete")
    public ResponseEntity<?> deleteStudentToSubject(@RequestParam(required = true) String idSubject, @RequestParam(required = false) String idStudent) {
        if (idStudent == null) {
            if (subjectService.deleteStudentsToSubject(idSubject) == 1) {
                return ResponseEntity.ok("Registro de estudiantes eliminados correctamente");
            }
            return ResponseEntity.status(400).body("La asignatura no tiene registros");
        } else {
            Integer response = subjectService.deleteStudentToSubject(idSubject, idStudent);
            if (response == 1) {
                return ResponseEntity.ok("Registro de estudiante eliminado correctamente");
            } else if (response == 0) {
                return ResponseEntity.status(400).body("El registro que desea eliminar no existe");
            }
            return ResponseEntity.status(400).body("Ocurrió un error inesperado");
        }
    }

}
