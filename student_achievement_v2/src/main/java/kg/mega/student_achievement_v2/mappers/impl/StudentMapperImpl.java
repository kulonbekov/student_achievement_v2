package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.models.entities.Student;
import kg.mega.student_achievement_v2.models.responses.ExamResponse;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;
import kg.mega.student_achievement_v2.models.responses.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    
    public StudentResponse studentDtoToResponse(List<Grade> grade) {

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setLastName(grade.get(0).getStudent().getLastName());
        studentResponse.setFirstName(grade.get(0).getStudent().getFirstName());
        studentResponse.setPatronymic(grade.get(0).getStudent().getPatronymic());

        List<SubjectResponse> subjectResponses = new ArrayList<>();
        for (int i = 0; i < grade.size(); i++) {
            ExamResponse examResponse = new ExamResponse();
            examResponse.setDate(grade.get(i).getExam().getExamDate());
            examResponse.setGradeEnum(grade.get(i).getGradeEnum());

            SubjectResponse subjectResponse = new SubjectResponse();
            subjectResponse.setName(grade.get(i).getExam().getSubject().getName());
            subjectResponse.setTeacherName(grade.get(i).getExam().getSubject().getTeacher().getFirstName());
            subjectResponse.setExamResponse(examResponse);
            subjectResponses.add(subjectResponse);
        }
        studentResponse.setSubjectResponse(subjectResponses);

        return studentResponse;
    }
}
