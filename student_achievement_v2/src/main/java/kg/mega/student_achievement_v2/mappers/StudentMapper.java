package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Student;

public interface StudentMapper {

    Student studentDtoToEntity(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);
}
