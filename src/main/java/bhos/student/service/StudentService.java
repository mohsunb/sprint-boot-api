package bhos.student.service;

import bhos.student.dto.ResponseDTO;
import bhos.student.dto.StudentDTO;
import bhos.student.mapper.DTOMapper;
import bhos.student.entity.Student;
import bhos.student.repository.StudentRepository;
import io.swagger.models.Response;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDTO> getStudents() {
        List<StudentDTO> list = new ArrayList<>();
        for (Student s : repository.findAll())
            list.add(DTOMapper.INSTANCE.studentDTO(s));
        return list;
    }

    public ResponseDTO addNewStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentBySurname(student.getSurname());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("surname taken");
        }

        repository.save(student);

        Response response = new Response().description("A new student was added successfully. {Name: "
                + student.getName() + ", Surname: " + student.getSurname() + "}");
        return DTOMapper.INSTANCE.responseDTO(response);
    }

    public ResponseDTO deleteStudent(Integer studentId) {
        if (!repository.existsById(studentId)) {
            throw new IllegalStateException("a student with id " + studentId + " does not exist");
        }

        repository.deleteById(studentId);

        Response response = new Response().description("Student with the ID " + studentId + " was deleted successfully.");
        return DTOMapper.INSTANCE.responseDTO(response);
    }

    @Transactional
    public ResponseDTO updateStudent(Integer studentId, String name, String surname) {
        Student student = repository.findById(studentId).orElseThrow(() ->  new IllegalStateException("a student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName(name);

        if (surname != null && surname.length() > 0 && !Objects.equals(student.getSurname(), surname)) {
            if (repository.findStudentBySurname(surname).isPresent())
                throw new IllegalStateException("this surname is already taken");
            student.setSurname(surname);
        }


        Response response =  new Response().description("Student with the ID "
                + studentId
                + " was updated successfully. {name: "
                + student.getName()
                + ", surname: "
                + student.getSurname()
                + "}");
        return DTOMapper.INSTANCE.responseDTO(response);
    }
}
