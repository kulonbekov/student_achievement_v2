package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {

    SubjectDto save (SubjectDto subjectDto);
    SubjectDto findById (Long id);
    List<SubjectDto> findAll();
    ResponseEntity<?> delete (Long id);
}
