package bhos.student.mapper;

import bhos.student.dto.StudentDTO;
import bhos.student.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentDTO(Student student);
}
