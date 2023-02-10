package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;
    private final SubjectRep subjectRep;

    public SubjectServiceImpl(SubjectMapper subjectMapper, SubjectRep subjectRep) {
        this.subjectMapper = subjectMapper;
        this.subjectRep = subjectRep;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = subjectMapper.subjectDtoToEntity(subjectDto);
        subject = subjectRep.save(subject);
        subjectDto.setId(subject.getId());

        return subjectDto;
    }
}
