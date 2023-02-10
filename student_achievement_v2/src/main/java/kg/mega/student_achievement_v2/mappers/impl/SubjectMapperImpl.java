package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
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
        teacher.setActive(subjectDto.getTeacherDto().isActive());
        teacher.setFirstName(subjectDto.getTeacherDto().getFirstName());
        teacher.setLastName(subjectDto.getTeacherDto().getLastName());
        teacher.setPatronymic(subjectDto.getTeacherDto().getPatronymic());

        subject.setTeacher(teacher);
        return subject;
    }

    @Override
    public SubjectDto subjectToSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setActive(subject.isActive());

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(subject.getTeacher().getId());
        teacherDto.setLastName(subject.getTeacher().getLastName());
        teacherDto.setFirstName(subject.getTeacher().getFirstName());
        teacherDto.setPatronymic(subject.getTeacher().getPatronymic());

        subjectDto.setTeacherDto(teacherDto);
        return subjectDto;
    }
}
