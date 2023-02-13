package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.student_achievement_v2.models.enums.GradeEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GradeDto {
    Long id;
    @JsonProperty("student")
    StudentDto studentDto;
    @JsonProperty("exam")
    ExamDto examDto;
    GradeEnum gradeEnum;
}
