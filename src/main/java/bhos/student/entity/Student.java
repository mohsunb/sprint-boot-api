package bhos.student.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
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

    public Student() {

    }

    public Student(Integer id,
                   String name,
                   String surname,
                   LocalDate birthdate,
                   String birthplace,
                   String profession) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.profession = profession;
    }

    public Student(String name,
                   String surname,
                   LocalDate birthdate,
                   String birthplace,
                   String profession) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.birthplace = birthplace;
        this.profession = profession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", birthplace='" + birthplace + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }

    public Integer getAge() {
        return Period.between(this.birthdate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
