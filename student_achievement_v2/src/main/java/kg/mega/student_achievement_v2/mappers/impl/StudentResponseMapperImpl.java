package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.mappers.StudentResponseMapper;
import kg.mega.student_achievement_v2.models.entities.Grade;
import kg.mega.student_achievement_v2.models.responses.ExamResponse;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;
import kg.mega.student_achievement_v2.models.responses.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseMapperImpl implements StudentResponseMapper {
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
