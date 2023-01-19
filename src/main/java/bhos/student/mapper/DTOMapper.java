package bhos.student.mapper;

import bhos.student.dto.ResponseDTO;
import bhos.student.dto.StudentDTO;
import bhos.student.entity.Student;
import io.swagger.models.Response;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DTOMapper {
    DTOMapper INSTANCE = Mappers.getMapper(DTOMapper.class);

    StudentDTO studentDTO(Student student);
    ResponseDTO responseDTO(Response response);
}
