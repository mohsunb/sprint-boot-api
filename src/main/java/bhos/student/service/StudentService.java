package bhos.student.service;

import bhos.student.entity.Student;
import bhos.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;



    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = repository.findStudentBySurname(student.getSurname());
        if (studentOptional.isPresent())
        {
            throw new IllegalStateException("surname taken");
        }

        repository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        if (!repository.existsById(studentId)) {
            throw new IllegalStateException("a student with id " + studentId + " does not exist");
        }

        repository.deleteById(studentId);
    }

    @Transactional
    public StudentDto updateStudent(Integer studentId, String name, String surname) {
        Student student = repository.findById(studentId).orElseThrow(() ->  new IllegalStateException("a student with id " + studentId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
            student.setName(name);

        if (surname != null && surname.length() > 0 && !Objects.equals(student.getSurname(), surname)) {
            if (repository.findStudentBySurname(surname).isPresent())
                throw new IllegalStateException("this surname is already taken");
            student.setSurname(surname);
        }
    }
}
