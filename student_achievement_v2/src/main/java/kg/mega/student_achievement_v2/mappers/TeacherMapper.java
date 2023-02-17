package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher teacherDtoToEntity (TeacherDto teacherDto);
    List<Teacher> teacherDtoToEntities (List<TeacherDto> teacherDto);
    TeacherDto teacherToTeacherDto(Teacher teacher);
    List<TeacherDto> teacherToTeacherDtos(List<Teacher> teacher);
}
