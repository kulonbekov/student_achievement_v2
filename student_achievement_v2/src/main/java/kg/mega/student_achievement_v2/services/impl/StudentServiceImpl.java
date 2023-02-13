package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.StudentRep;
import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Student;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRep studentRep;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRep studentRep, StudentMapper studentMapper) {
        this.studentRep = studentRep;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.studentDtoToEntity(studentDto);
        student = studentRep.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = studentRep.findById(id).orElseThrow(()-> new RuntimeException("Студент не найден"));
        StudentDto studentDto = studentMapper.studentToStudentDto(student);
        return studentDto;
    }
}
