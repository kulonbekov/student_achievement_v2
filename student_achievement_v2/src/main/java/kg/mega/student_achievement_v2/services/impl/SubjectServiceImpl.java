package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ExamRep;
import kg.mega.student_achievement_v2.dao.SubjectRep;
import kg.mega.student_achievement_v2.mappers.SubjectMapper;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Subject;
import kg.mega.student_achievement_v2.services.SubjectService;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRep subjectRep;
    private final TeacherService teacherService;
    private final ExamRep examRep;

    public SubjectServiceImpl( SubjectRep subjectRep, TeacherService teacherService,
                               ExamRep examRep) {
        this.subjectRep = subjectRep;
        this.teacherService = teacherService;
        this.examRep = examRep;
    }

    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
        subject = subjectRep.save(subject);
        subjectDto.setId(subject.getId());
        subjectDto.setTeacherDto(teacherService.findById(subject.getTeacher().getId()));
        return subjectDto;
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject subject = subjectRep.findById(id).orElseThrow(()-> new RuntimeException("Subject not found"));
        subject = subjectRep.findById(id).orElseThrow(()-> new RuntimeException("Subject not found"));
        SubjectDto subjectDto = SubjectMapper.INSTANCE.subjectToSubjectDto(subject);
        return subjectDto;
    }

    @Override
    public List<SubjectDto> findAll() {
        return SubjectMapper.INSTANCE.subjectToSubjectDtos(subjectRep.findAll());
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        List<Exam> exams = examRep.findBySubject(id);
        for (Exam item: exams) {
            if(item.getExamDate().after(new Date()))
                return ResponseEntity.status(404).body("Error! Cannot be deleted");
        }
        SubjectDto subjectDto = findById(id);
        subjectDto.setActive(false);
        Subject subject = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
        subjectRep.save(subject);
        return ResponseEntity.ok(subjectDto);
    }

    @Override
    public ResponseEntity<?> update(SubjectDto subjectDto) {
        Subject subject = null;
        try{
            teacherService.update(subjectDto.getTeacherDto());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found, cannot be updated!");
        }
        try {
            subject = subjectRep.findById(subjectDto.getId()).orElseThrow(() -> new RuntimeException("Subject not found"));

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject not found, cannot be updated!");
        }
        subject = SubjectMapper.INSTANCE.subjectDtoToEntity(subjectDto);
        subject = subjectRep.save(subject);
        return ResponseEntity.ok(SubjectMapper.INSTANCE.subjectToSubjectDto(subject));




    }
}
