package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.mappers.TeacherMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class SubjectMapperImpl implements SubjectMapper {

    private final TeacherMapper teacherMapper;

    public SubjectMapperImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }


    @Override
    public Subject subjectDtoToEntity(SubjectDto subjectDto) {

        Subject subject = new Subject();
        subject.setId(subjectDto.getId());
        subject.setName(subjectDto.getName());
        subject.setActive(subjectDto.isActive());

        subject.setTeacher(teacherMapper.teacherDtoToEntity(subjectDto.getTeacherDto()));
        return subject;
    }

    @Override
    public SubjectDto subjectToSubjectDto(Subject subject) {
        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(subject.getId());
        subjectDto.setName(subject.getName());
        subjectDto.setActive(subject.isActive());

        subjectDto.setTeacherDto(teacherMapper.teacherToTeacherDto(subject.getTeacher()));
        return subjectDto;
    }
}
