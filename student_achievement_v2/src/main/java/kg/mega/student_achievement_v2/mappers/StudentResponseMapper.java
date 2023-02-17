package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;

import java.util.List;

public interface StudentResponseMapper {
    StudentResponse studentDtoToResponse(List<Grade> grade);
}
