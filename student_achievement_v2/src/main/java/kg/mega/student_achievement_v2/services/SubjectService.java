package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.SubjectDto;

public interface SubjectService {

    SubjectDto save (SubjectDto subjectDto);
    SubjectDto findById (Long id);
}
