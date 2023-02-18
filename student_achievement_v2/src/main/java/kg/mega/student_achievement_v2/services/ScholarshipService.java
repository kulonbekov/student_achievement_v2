package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;

import java.util.List;

public interface ScholarshipService {

    ScholarshipDto save (ScholarshipDto scholarshipDto);
    ScholarshipDto findById(Long id);
    List<ScholarshipDto> findAll();
    void changeEndDate(Long id);
}
