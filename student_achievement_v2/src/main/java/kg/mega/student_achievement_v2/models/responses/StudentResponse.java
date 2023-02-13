package kg.mega.student_achievement_v2.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {

    @JsonProperty("surname")
    String lastName;
    @JsonProperty("name")
    String firstName;
    String patronymic;
    @JsonProperty("scholarship")
    double scholarshipAmount;
    @JsonProperty("subject")
    List<SubjectResponse> subjectResponse;
}
