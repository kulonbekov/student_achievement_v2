package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface TeacherService {

    TeacherDto save (TeacherDto teacherDto);
    TeacherDto findById (Long id);
    ResponseEntity<?> delete (Long id);
}
