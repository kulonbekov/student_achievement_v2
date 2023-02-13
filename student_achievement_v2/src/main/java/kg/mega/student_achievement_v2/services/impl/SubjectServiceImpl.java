package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.services.SubjectService;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;
    private final SubjectRep subjectRep;
    private final TeacherService teacherService;

    public SubjectServiceImpl(SubjectMapper subjectMapper, SubjectRep subjectRep, TeacherService teacherService) {
        this.subjectMapper = subjectMapper;
        this.subjectRep = subjectRep;
        this.teacherService = teacherService;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = subjectMapper.subjectDtoToEntity(subjectDto);
        subject = subjectRep.save(subject);
        subjectDto.setId(subject.getId());
        subjectDto.setTeacherDto(teacherService.findById(subject.getTeacher().getId()));
        return subjectDto;
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject subject = subjectRep.findById(id).orElseThrow(()-> new RuntimeException("Предмет не найден"));
        SubjectDto subjectDto = subjectMapper.subjectToSubjectDto(subject);
        return subjectDto;
    }
}
