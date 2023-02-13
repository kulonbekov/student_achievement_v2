package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;

public interface ScholarshipService {

    ScholarshipDto save (ScholarshipDto scholarshipDto);
    ScholarshipDto findById(Long id);

    void changeEndDate(Long id);
}
