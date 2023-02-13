package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.GradeDto;

public interface GradeService {

    GradeDto save (GradeDto gradeDto);
    GradeDto findById(Long id);
}
