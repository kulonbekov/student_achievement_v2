package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Subject;

public interface ExamMapper {


    Exam examDtoToEntity (ExamDto examDto);

    ExamDto examToExamDto (Exam exam);
}
