package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ExamRep;
import kg.mega.student_achievement_v2.dao.StudentRep;
import kg.mega.student_achievement_v2.mappers.ExamEmailMapper;
import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Student;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.NotificationService;
import kg.mega.student_achievement_v2.services.SubjectService;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRep examRep;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final StudentRep studentRep;
    private final ExamEmailMapper examEmailMapper;
    private final NotificationService notificationService;


    public ExamServiceImpl(ExamRep examRep, SubjectService subjectService, TeacherService teacherService, StudentRep studentRep, ExamEmailMapper examEmailMapper, NotificationService notificationService) {
        this.examRep = examRep;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.studentRep = studentRep;
        this.examEmailMapper = examEmailMapper;
        this.notificationService = notificationService;
    }

    @Override
    public ResponseEntity<?> save(ExamDto examDto) { //будние дни с 09:00 - 17:00

        if(!checkDate(examDto.getExamDate(),examDto.getDuration())){
            return ResponseEntity.status(404).body("Invalid date and time!");
        }else {
            Exam exam = ExamMapper.INSTANCE.examDtoToEntity(examDto);
            exam = examRep.save(exam);
            examDto.setId(exam.getId());
            examDto.setSubjectDto(subjectService.findById(exam.getSubject().getId()));
            settingEmail(examDto);
            return ResponseEntity.ok(examDto);
        }

    }

    @Override
    public ExamDto findById(Long id) {
        Exam exam = examRep.findById(id).orElseThrow(()-> new RuntimeException("Экзамен не найден"));
        ExamDto examDto = ExamMapper.INSTANCE.examToExamDto(exam);
        return examDto;
    }

    @Override
    public List<ExamDto> findAll() {
        return ExamMapper.INSTANCE.examToExamDtos(examRep.findAll());
    }

    @Override
    public Boolean checkDate(Date date, int duration) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        Calendar currentTime = Calendar.getInstance();
        currentTime.setTime(new Date());

        Calendar dateTime = Calendar.getInstance();
        dateTime.setTime(date);
        dateTime.add(Calendar.MINUTE,duration);

        Calendar date1 = Calendar.getInstance();
        date1.setTime(date);
        date1.set(Calendar.HOUR_OF_DAY, 9);
        date1.set(Calendar.MINUTE, 00);
        date1.set(Calendar.SECOND, 00);

        Calendar date2 = Calendar.getInstance();
        date2.setTime(date);
        date2.set(Calendar.HOUR_OF_DAY, 17);
        date2.set(Calendar.MINUTE, 00);
        date2.set(Calendar.SECOND, 00);

        if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY
                || calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY
                || calendar.get(Calendar.DAY_OF_YEAR)<(currentTime.get(Calendar.DAY_OF_YEAR))
                || calendar.getTime().before(currentTime.getTime())
                || calendar.getTime().before(date1.getTime())
                || dateTime.getTime().after(date2.getTime())){
                return false;

        }
        return true;
    }

    @Override
    public void settingEmail(ExamDto examDto) { // При добавления нового экзамена, отправляется письмо студенту по почте
        StudentDto studentDto = StudentMapper.INSTANCE.studentToStudentDto(studentRep.findbyStudent(examDto.getSubjectDto().getId()));
        String email = studentDto.getEmail();
        String subject = "Exam: " + examDto.getSubjectDto().getName();
        String text = examEmailMapper.examDtoToString(examDto);

        try {
            notificationService.send(email, subject, text);
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public ResponseEntity<?> update(ExamDto examDto) {
        Exam exam = null;
        try{
            subjectService.update(examDto.getSubjectDto());
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subject not found, cannot be updated!");
        }
        try{
            teacherService.update(examDto.getSubjectDto().getTeacherDto());
        }catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found, cannot be updated!");
        }
        try{
            exam = examRep.findById(examDto.getId()).orElseThrow(()-> new RuntimeException("Exam not found"));
            exam = ExamMapper.INSTANCE.examDtoToEntity(examDto);
            exam = examRep.save(exam);
            return ResponseEntity.status(HttpStatus.OK).body(ExamMapper.INSTANCE.examToExamDto(exam));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found, cannot be updated!");
        }

    }
}
