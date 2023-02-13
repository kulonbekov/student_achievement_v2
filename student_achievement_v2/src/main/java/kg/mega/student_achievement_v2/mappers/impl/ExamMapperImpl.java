package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class ExamMapperImpl implements ExamMapper {

    private final SubjectMapper subjectMapper;

    public ExamMapperImpl(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }


    @Override
    public Exam examDtoToEntity(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setExamDate(examDto.getExamDate());
        exam.setId(examDto.getId());
        exam.setDuration(examDto.getDuration());
        exam.setSubject(subjectMapper.subjectDtoToEntity(examDto.getSubjectDto()));

        return exam;
    }

    @Override
    public ExamDto examToExamDto(Exam exam) {
        ExamDto examDto = new ExamDto();
        examDto.setExamDate(exam.getExamDate());
        examDto.setDuration(exam.getDuration());
        examDto.setId(exam.getId());

        examDto.setSubjectDto(subjectMapper.subjectToSubjectDto(exam.getSubject()));

        return examDto;
    }
}
