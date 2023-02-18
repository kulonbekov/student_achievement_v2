package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.services.SubjectService;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRep subjectRep;
    private final TeacherService teacherService;

    public SubjectServiceImpl( SubjectRep subjectRep, TeacherService teacherService) {
        this.subjectRep = subjectRep;
        this.teacherService = teacherService;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
        subject = subjectRep.save(subject);
        subjectDto.setId(subject.getId());
        subjectDto.setTeacherDto(teacherService.findById(subject.getTeacher().getId()));
        return subjectDto;
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject subject = subjectRep.findById(id).orElseThrow(()-> new RuntimeException("Предмет не найден"));
        SubjectDto subjectDto = SubjectMapper.INSTANCE.subjectToSubjectDto(subject);
        return subjectDto;
    }

    @Override
    public List<SubjectDto> findAll() {
        return SubjectMapper.INSTANCE.subjectToSubjectDtos(subjectRep.findAll());
    }
}
