package kg.mega.student_achievement_v2.services;

import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;

public interface StudentService {


    StudentDto save(StudentDto studentDto);

    StudentDto findById(Long id);

    StudentResponse getByStudent(Long id);

    Double getScholarship(Long id);
}
