package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.TeacherMapper;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class TeacherMapperImpl implements TeacherMapper {
    @Override
    public Teacher teacherDtoToEntity(TeacherDto teacherDto) {

        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setPatronymic(teacherDto.getPatronymic());
        teacher.setActive(teacherDto.isActive());
        return teacher;
    }
}
