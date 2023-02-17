package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ExamRep;
import kg.mega.student_achievement_v2.mappers.ExamMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


@Service
public class ExamServiceImpl implements ExamService {

    private final ExamMapper examMapper;
    private final ExamRep examRep;
    private final SubjectService subjectService;

    public ExamServiceImpl(ExamMapper examMapper, ExamRep examRep, SubjectService subjectService) {
        this.examMapper = examMapper;
        this.examRep = examRep;
        this.subjectService = subjectService;
    }

    @Override
    public ResponseEntity<?> save(ExamDto examDto) { //будние дни с 09:00 - 17:00

        if(!checkDate(examDto.getExamDate(),examDto.getDuration())){
            return ResponseEntity.status(404).body("Invalid date and time!");
        }else {
            Exam exam = examMapper.examDtoToEntity(examDto);
            exam = examRep.save(exam);
            examDto.setId(exam.getId());
            examDto.setSubjectDto(subjectService.findById(exam.getSubject().getId()));
            return ResponseEntity.ok(examDto);
        }

    }

    @Override
    public ExamDto findById(Long id) {
        Exam exam = examRep.findById(id).orElseThrow(()-> new RuntimeException("Экзамен не найден"));
        ExamDto examDto = examMapper.examToExamDto(exam);
        return examDto;
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
}
