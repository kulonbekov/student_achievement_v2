package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMapperImpl implements StudentMapper {
    private final SubjectMapper subjectMapper;

    public StudentMapperImpl(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public Student studentDtoToEntity(StudentDto studentDto) {

        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPatronymic(studentDto.getPatronymic());
        student.setActive(studentDto.isActive());
        student.setAddress(studentDto.getAddress());

        student.setSubject(subjectMapper.subjectDtoToEntity(studentDto.getSubjectDto()));
        return student;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setLastName(student.getLastName());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setPatronymic(student.getPatronymic());
        studentDto.setAddress(student.getAddress());
        studentDto.setActive(student.isActive());

        studentDto.setSubjectDto(subjectMapper.subjectToSubjectDto(student.getSubject()));
        return studentDto;
    }
}
