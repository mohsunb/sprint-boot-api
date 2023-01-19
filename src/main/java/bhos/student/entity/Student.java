package bhos.student.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
@Data
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String birthplace;
    private String profession;
    @Transient
    private Integer age;


}
