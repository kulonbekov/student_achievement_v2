package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.mappers.GradeMapper;
import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.entities.Grade;
import org.springframework.stereotype.Service;

@Service
public class GradeMapperImpl implements GradeMapper {
    private final StudentMapper studentMapper;
    private final ExamMapper examMapper;

    public GradeMapperImpl(StudentMapper studentMapper, ExamMapper examMapper) {
        this.studentMapper = studentMapper;
        this.examMapper = examMapper;
    }


    @Override
    public Grade gradeDtoToEntity(GradeDto gradeDto) {
        Grade grade = new Grade();
        grade.setId(gradeDto.getId());
        grade.setGradeEnum(gradeDto.getGradeEnum());

        grade.setStudent(studentMapper.studentDtoToEntity(gradeDto.getStudentDto()));
        grade.setExam(examMapper.examDtoToEntity(gradeDto.getExamDto()));
        return grade;
    }

    @Override
    public GradeDto gradeToGradeDto(Grade grade) {
        GradeDto gradeDto = new GradeDto();
        gradeDto.setId(grade.getId());
        gradeDto.setGradeEnum(grade.getGradeEnum());

        gradeDto.setStudentDto(studentMapper.studentToStudentDto(grade.getStudent()));
        gradeDto.setExamDto(examMapper.examToExamDto(grade.getExam()));
        return gradeDto;
    }
}
