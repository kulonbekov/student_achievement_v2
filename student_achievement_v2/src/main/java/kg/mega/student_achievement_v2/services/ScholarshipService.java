package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;

public interface ScholarshipService {

   /* ExamDto save (ExamDto examDto);
    ExamDto findById(Long id);*/

    ScholarshipDto save (ScholarshipDto scholarshipDto);
    ScholarshipDto findById(Long id);
}
