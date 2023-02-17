package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "subjectDto", target = "subject")
    @Mapping(source = "subjectDto.teacherDto", target = "subject.teacher")
    Student studentDtoToEntity(StudentDto studentDto);
    List<Student> studentDtoToEntities(List<StudentDto> studentDto);
    @Mapping(source = "subject", target = "subjectDto")
    @Mapping(source = "subject.teacher", target = "subjectDto.teacherDto")
    StudentDto studentToStudentDto(Student student);
    List<StudentDto> studentToStudentDtos(List<Student> student);






}
