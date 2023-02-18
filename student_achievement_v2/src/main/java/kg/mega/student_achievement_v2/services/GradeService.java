package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;

import java.util.List;

public interface GradeService {

    GradeDto save (GradeDto gradeDto);
    GradeDto findById(Long id);
    List<GradeDto> findAll();
}
