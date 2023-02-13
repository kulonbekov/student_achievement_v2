package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.GradeRep;
import kg.mega.student_achievement_v2.mappers.GradeMapper;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.GradeService;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeMapper gradeMapper;
    private final GradeRep gradeRep;
    private final StudentService studentService;
    private final ExamService examService;

    public GradeServiceImpl(GradeMapper gradeMapper, GradeRep gradeRep, StudentService studentService, ExamService examService) {
        this.gradeMapper = gradeMapper;
        this.gradeRep = gradeRep;
        this.studentService = studentService;
        this.examService = examService;
    }

    @Override
    public GradeDto save(GradeDto gradeDto) {
        Grade grade = gradeMapper.gradeDtoToEntity(gradeDto);
        grade = gradeRep.save(grade);
        gradeDto.setId(grade.getId());
        gradeDto.setStudentDto(studentService.findById(grade.getStudent().getId()));
        gradeDto.setExamDto(examService.findById(grade.getExam().getId()));
        return gradeDto;
    }

    @Override
    public GradeDto findById(Long id) {
        Grade grade = gradeRep.findById(id).orElseThrow(()->new RuntimeException("Запись не найден"));
        GradeDto gradeDto = gradeMapper.gradeToGradeDto(grade);
        return gradeDto;
    }
}
