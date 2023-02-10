package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScholarshipDto {
    Long id;
    double scholarshipAmount;
    Date startDate;
    Date endDate;
    @JsonProperty("student_id")
    StudentDto studentDto;

}
