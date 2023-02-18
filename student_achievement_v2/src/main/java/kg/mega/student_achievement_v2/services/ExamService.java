package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface ExamService {

    ResponseEntity<?> save (ExamDto examDto);
    ExamDto findById(Long id);
    List<ExamDto> findAll();

    Boolean checkDate(Date date, int duration);

    void settingEmail(ExamDto examDto);



}
