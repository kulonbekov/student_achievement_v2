package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.GradeRep;
import kg.mega.student_achievement_v2.dao.ScholarshipRep;
import kg.mega.student_achievement_v2.dao.StudentRep;
import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.mappers.GradeMapper;
import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.mappers.StudentResponseMapper;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.models.entities.Scholarship;
import kg.mega.student_achievement_v2.models.entities.Student;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;
import kg.mega.student_achievement_v2.services.StudentService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRep studentRep;
    private final StudentResponseMapper studentResponseMapper;
    private final SubjectService subjectService;
    private final ScholarshipRep scholarshipRep;
    private final GradeRep gradeRep;
    private final SubjectRep subjectRep;

    public StudentServiceImpl(StudentRep studentRep,  StudentResponseMapper studentResponseMapper, SubjectService subjectService, ScholarshipRep scholarshipRep, GradeRep gradeRep,
                              SubjectRep subjectRep) {
        this.studentRep = studentRep;
        this.studentResponseMapper = studentResponseMapper;
        this.subjectService = subjectService;
        this.scholarshipRep = scholarshipRep;
        this.gradeRep = gradeRep;
        this.subjectRep = subjectRep;
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = StudentMapper.INSTANCE.studentDtoToEntity(studentDto);
        student = studentRep.save(student);
        studentDto.setId(student.getId());
        studentDto.setSubjectDto(subjectService.findById(student.getSubject().getId()));
        return studentDto;
    }

    @Override
    public StudentDto findById(Long id) {
        Student student = studentRep.findById(id).orElseThrow(()-> new RuntimeException("?????????????? ???? ????????????"));
        StudentDto studentDto = StudentMapper.INSTANCE.studentToStudentDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> findAll() {
        return StudentMapper.INSTANCE.studentToStudentDtos(studentRep.findAll());
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = studentRep.findById(studentDto.getId()).orElseThrow(()-> new RuntimeException("?????????????? ???? ????????????"));
        StudentDto newStudentDto = StudentMapper.INSTANCE.studentToStudentDto(student);
        newStudentDto = studentResponseMapper.studentDtoTDto(studentDto,newStudentDto);
        student = StudentMapper.INSTANCE.studentDtoToEntity(newStudentDto);
        return StudentMapper.INSTANCE.studentToStudentDto(studentRep.save(student));
    }

    @Override
    public StudentResponse getByStudent(Long id) {
        List<Grade> grades = gradeRep.findByStudent(id);
        StudentResponse studentResponse = studentResponseMapper.studentDtoToResponse(grades);
        studentResponse.setScholarshipAmount(getScholarship(id));
        return studentResponse;
    }

    @Override
    public Double getScholarship(Long id) {
        Date correntDate = new Date();
        double scholarship = 0;
        List<Scholarship> scholarships = scholarshipRep.findByStudentId(id);
        for (Scholarship item: scholarships) {
            if(item.getEndDate().after(correntDate));
            scholarship = item.getScholarshipAmount();
            break;
        }
        return scholarship;
    }


}
