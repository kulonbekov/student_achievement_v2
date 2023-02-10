package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.TeacherRep;
import kg.mega.student_achievement_v2.mappers.TeacherMapper;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherRep teacherRep;

    public TeacherServiceImpl(TeacherMapper teacherMapper, TeacherRep teacherRep) {
        this.teacherMapper = teacherMapper;
        this.teacherRep = teacherRep;
    }


    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.teacherDtoToEntity(teacherDto);
        teacher = teacherRep.save(teacher);
        teacherDto.setId(teacher.getId());

        return teacherDto;
    }
}
