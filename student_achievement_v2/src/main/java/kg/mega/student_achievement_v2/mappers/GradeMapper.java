package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Grade;

public interface GradeMapper {


    Grade gradeDtoToEntity (GradeDto gradeDto);
    GradeDto gradeToGradeDto (Grade grade);
}
