package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapperImpl implements SubjectMapper {
    @Override
    public Subject subjectDtoToEntity(SubjectDto subjectDto) {

        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setActive(subjectDto.isActive());

        Teacher teacher = new Teacher();
        teacher.setId(subjectDto.getTeacherDto().getId());

        subject.setTeacher(teacher);
        return subject;
    }
}
