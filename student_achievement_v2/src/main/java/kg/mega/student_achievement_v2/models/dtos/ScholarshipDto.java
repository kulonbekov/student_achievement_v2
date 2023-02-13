package kg.mega.student_achievement_v2.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScholarshipDto {
    Long id;
    @JsonProperty("amount")
    double scholarshipAmount;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date endDate;
    @JsonProperty("student")
    StudentDto studentDto;

}
