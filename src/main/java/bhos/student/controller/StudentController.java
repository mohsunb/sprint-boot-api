package bhos.student.controller;

import bhos.student.dto.ResponseDTO;
import bhos.student.dto.StudentDTO;
import bhos.student.entity.Student;
import bhos.student.service.StudentService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> getStudents() {
        return service.getStudents();
    }

    @PostMapping
    public ResponseDTO registerNewStudent(@RequestBody Student student) {
        return service.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseDTO deleteStudent(@PathVariable("studentId") Integer studentId) {
        return service.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public ResponseDTO updateStudent(@PathVariable("studentId") Integer studentId,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) String surname) {
        return service.updateStudent(studentId, name, surname);
    }
}
