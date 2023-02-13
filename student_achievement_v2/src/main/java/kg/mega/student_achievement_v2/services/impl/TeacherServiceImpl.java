package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.dao.TeacherRep;
import kg.mega.student_achievement_v2.mappers.TeacherMapper;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherRep teacherRep;
    private final SubjectRep subjectRep;

    public TeacherServiceImpl(TeacherMapper teacherMapper, TeacherRep teacherRep,
                              SubjectRep subjectRep) {
        this.teacherMapper = teacherMapper;
        this.teacherRep = teacherRep;
        this.subjectRep = subjectRep;
    }


    @Override
    public TeacherDto save(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.teacherDtoToEntity(teacherDto);
        teacher = teacherRep.save(teacher);
        teacherDto.setId(teacher.getId());

        return teacherDto;
    }

    @Override
    public TeacherDto findById(Long id) {
        Teacher teacher = teacherRep.findById(id).orElseThrow(()-> new RuntimeException("Преподаватель не найден"));
        TeacherDto teacherDto = teacherMapper.teacherToTeacherDto(teacher);
        return teacherDto;
    }

    @Override
    public String delete(Long id) {

        List<Subject> subjectList = subjectRep.findByTeacher(id);
        for (Subject item: subjectList) {
            if(item.isActive());
            return "Error! Cannot be deleted";
        }
        TeacherDto teacherDto = findById(id);
        teacherDto.setActive(false);
        Teacher teacher = teacherMapper.teacherDtoToEntity(teacherDto);
        teacherRep.save(teacher);
        return "1 entry record successfully deleted";
    }
}
