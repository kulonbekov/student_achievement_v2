package kg.mega.student_achievement_v2.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectResponse {

    @JsonProperty("name")
    String name;
    @JsonProperty("teacher_name")
    String teacherName;
    @JsonProperty("exam")
    ExamResponse examResponse;
}
