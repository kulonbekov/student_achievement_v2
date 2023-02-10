package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    Long id;
    String lastName;
    String firstName;
    String patronymic;
    boolean active;
    String address;
    @JsonProperty("subject")
    SubjectDto subjectDto;
}
