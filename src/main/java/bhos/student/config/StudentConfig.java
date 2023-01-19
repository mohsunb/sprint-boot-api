package bhos.student.config;

import bhos.student.entity.Student;
import bhos.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mohsun = new Student(
                    "Mohsun",
                    "Babayev",
                    LocalDate.of(2003, Month.OCTOBER, 4),
                    "Baku",
                    "Student"
            );

            Student ebulfez = new Student(
                    "Ebulfez",
                    "Ceferov",
                    LocalDate.of(2001, Month.DECEMBER, 9),
                    "Baku",
                    "Student"
            );

            repository.saveAll(List.of(mohsun, ebulfez));
        };
    }
}
