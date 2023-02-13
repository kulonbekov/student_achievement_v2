package kg.mega.student_achievement_v2.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import kg.mega.student_achievement_v2.models.utils.DateUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "scholarships")
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    double scholarshipAmount;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date startDate;
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;


    @PrePersist
    protected void onCreate() {
        endDate = DateUtil.getINSTANCE().getEndDate();
        startDate = new Date();
    }





}
