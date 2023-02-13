package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ExamRep;
import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService {

    private final ExamMapper examMapper;
    private final ExamRep examRep;
    private final SubjectService subjectService;

    public ExamServiceImpl(ExamMapper examMapper, ExamRep examRep, SubjectService subjectService) {
        this.examMapper = examMapper;
        this.examRep = examRep;
        this.subjectService = subjectService;
    }

    @Override
    public ExamDto save(ExamDto examDto) {
        Exam exam = examMapper.examDtoToEntity(examDto);
        exam = examRep.save(exam);
        examDto.setId(exam.getId());
        examDto.setSubjectDto(subjectService.findById(exam.getSubject().getId()));
        return examDto;
    }

    @Override
    public ExamDto findById(Long id) {
        Exam exam = examRep.findById(id).orElseThrow(()-> new RuntimeException("Экзамен не найден"));
        ExamDto examDto = examMapper.examToExamDto(exam);
        return examDto;
    }
}
