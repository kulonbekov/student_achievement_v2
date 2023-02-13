package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.models.entities.Student;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;
import kg.mega.student_achievement_v2.models.responses.SubjectResponse;

import java.util.List;

public interface StudentMapper {

    Student studentDtoToEntity(StudentDto studentDto);

    StudentDto studentToStudentDto(Student student);


    StudentResponse studentDtoToResponse(List<Grade> grades);


}
