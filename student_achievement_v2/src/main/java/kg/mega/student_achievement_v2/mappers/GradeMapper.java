package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);
    @Mapping(source = "studentDto", target = "student")
    @Mapping(source = "studentDto.subjectDto", target = "student.subject")
    @Mapping(source = "studentDto.subjectDto.teacherDto", target = "student.subject.teacher")
    @Mapping(source = "examDto", target = "exam")
    @Mapping(source = "examDto.subjectDto", target = "exam.subject")
    @Mapping(source = "examDto.subjectDto.teacherDto", target = "exam.subject.teacher")

    Grade gradeDtoToEntity (GradeDto gradeDto);
    List<Grade> gradeDtoToEntities (List<GradeDto> gradeDto);
    @Mapping(source = "student", target = "studentDto")
    @Mapping(source = "student.subject", target = "studentDto.subjectDto")
    @Mapping(source = "student.subject.teacher", target = "studentDto.subjectDto.teacherDto")
    @Mapping(source = "exam", target = "examDto")
    @Mapping(source = "exam.subject", target = "examDto.subjectDto")
    @Mapping(source = "exam.subject.teacher", target = "examDto.subjectDto.teacherDto")
    GradeDto gradeToGradeDto (Grade grade);
    List<GradeDto> gradeToGradeDtos (List<Grade> grade);
}
