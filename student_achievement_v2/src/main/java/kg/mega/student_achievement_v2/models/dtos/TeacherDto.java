package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherDto {
    Long id;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("patronymic")
    String patronymic;
    @JsonProperty("isActive")
    boolean active;
}
