package co.edu.unicauca.gesrotes.controllers;

import co.edu.unicauca.gesrotes.models.Student;
import co.edu.unicauca.gesrotes.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
        Optional<Student> student = Optional.empty();
        Optional<List<Student>> students = Optional.empty();

        if (id != null) {
            student = studentService.getStudentById(id);
        } else if (name != null) {
            students = studentService.getStudentByName(name);
        } else {
            students = studentService.getStudents();
        }

        if (student.isPresent()) {
            return ResponseEntity.ok(student);
        } else if (students.isPresent()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        if (studentService.addStudent(student)) {
            return ResponseEntity.ok("Estudiante creado exitosamente");
        }
        return ResponseEntity.status(409).body("El estudiante ya exite");
    }

}
