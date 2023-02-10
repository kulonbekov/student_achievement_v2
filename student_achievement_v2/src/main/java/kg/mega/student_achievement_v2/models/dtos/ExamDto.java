package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExamDto {

    Long id;
    Date examDate;
    int duration;
    @JsonProperty("subject")
    SubjectDto subjectDto;
}
