package kg.mega.student_achievement_v2.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.enums.GradeEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamResponse {

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonProperty("date")
    Date date;
    @JsonProperty("score")
    GradeEnum gradeEnum;
}
