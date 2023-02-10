package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.stereotype.Service;


public interface TeacherService {

    TeacherDto save (TeacherDto teacherDto);
}
