package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TeacherService {

    TeacherDto save (TeacherDto teacherDto);
    TeacherDto findById (Long id);
    List<TeacherDto> findAll();
    ResponseEntity<?> delete (Long id);

}
