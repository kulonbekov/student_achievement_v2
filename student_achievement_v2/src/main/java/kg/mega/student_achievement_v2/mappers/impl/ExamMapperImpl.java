package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;

@Service
public class ExamMapperImpl implements ExamMapper {
    @Override
    public Exam examDtoToEntity(ExamDto examDto) {
        Exam exam = new Exam();
        exam.setExamDate(examDto.getExamDate());
        exam.setId(examDto.getId());
        exam.setDuration(examDto.getDuration());

        Subject subject = new Subject();
        subject.setId(examDto.getSubjectDto().getId());
        subject.setActive(examDto.getSubjectDto().isActive());
        subject.setName(examDto.getSubjectDto().getName());

        Teacher teacher = new Teacher();
        teacher.setId(examDto.getSubjectDto().getTeacherDto().getId());
        teacher.setActive(examDto.getSubjectDto().getTeacherDto().isActive());
        teacher.setLastName(examDto.getSubjectDto().getTeacherDto().getLastName());
        teacher.setFirstName(examDto.getSubjectDto().getTeacherDto().getFirstName());
        teacher.setPatronymic(examDto.getSubjectDto().getTeacherDto().getPatronymic());
        subject.setTeacher(teacher);
        exam.setSubject(subject);
        return exam;
    }

    @Override
    public ExamDto examToExamDto(Exam exam) {
        ExamDto examDto = new ExamDto();
        examDto.setExamDate(exam.getExamDate());
        examDto.setDuration(exam.getDuration());
        examDto.setId(exam.getId());

        SubjectDto subjectDto = new SubjectDto();
        subjectDto.setId(exam.getSubject().getId());
        subjectDto.setName(exam.getSubject().getName());
        subjectDto.setActive(exam.getSubject().isActive());


        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(exam.getSubject().getTeacher().getId());
        teacherDto.setActive(exam.getSubject().getTeacher().isActive());
        teacherDto.setLastName(exam.getSubject().getTeacher().getLastName());
        teacherDto.setFirstName(exam.getSubject().getTeacher().getFirstName());
        teacherDto.setPatronymic(exam.getSubject().getTeacher().getPatronymic());

        subjectDto.setTeacherDto(teacherDto);
        examDto.setSubjectDto(subjectDto);

        return examDto;
    }
}
