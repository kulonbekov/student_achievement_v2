package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;

public interface TeacherMapper {

    Teacher teacherDtoToEntity (TeacherDto teacherDto);
}
