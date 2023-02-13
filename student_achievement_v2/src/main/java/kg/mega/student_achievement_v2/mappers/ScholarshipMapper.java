package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;

public interface ScholarshipMapper {

    Scholarship scholarshipDtoToEntity (ScholarshipDto scholarshipDto);

    ScholarshipDto scholarshipToScholarshipDto (Scholarship scholarship);
}
