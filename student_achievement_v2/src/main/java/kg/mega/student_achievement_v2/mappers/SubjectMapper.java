package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;

public interface SubjectMapper {

    Subject subjectDtoToEntity (SubjectDto subjectDto);
}
