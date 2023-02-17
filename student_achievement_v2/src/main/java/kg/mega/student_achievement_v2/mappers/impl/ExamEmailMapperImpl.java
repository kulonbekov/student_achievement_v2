package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.ExamEmailMapper;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import org.springframework.stereotype.Service;

@Service
public class ExamEmailMapperImpl implements ExamEmailMapper {
    @Override
    public String examDtoToString(ExamDto examDto) {
        String text = "Exam name: " + examDto.getSubjectDto().getName() +
                "\nExam date: " + examDto.getExamDate() +
                "\nTeacher name: " + examDto.getSubjectDto().getTeacherDto().getFirstName() +
                "\nTeacher surname: " + examDto.getSubjectDto().getTeacherDto().getLastName() +
                "\nDuration: " + examDto.getDuration() + " min";
        return text;
    }
}
