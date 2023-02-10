package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;

public interface ExamService {

    //SubjectDto save (SubjectDto subjectDto);
    //SubjectDto findById (Long id);

    ExamDto save (ExamDto examDto);
    ExamDto findById(Long id);


}
