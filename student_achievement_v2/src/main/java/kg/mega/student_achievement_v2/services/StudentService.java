package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.StudentDto;

public interface StudentService {


    StudentDto save(StudentDto studentDto);

    StudentDto findById(Long id);
}
