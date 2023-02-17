package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Exam;
import kg.mega.student_achievement_v2.models.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ExamMapper {

    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    @Mapping(source = "subjectDto", target = "subject")
    @Mapping(source = "subjectDto.teacherDto", target = "subject.teacher")
    Exam examDtoToEntity (ExamDto examDto);
    List<Exam> examDtoToEntities (List<ExamDto> examDto);

    @Mapping(source = "subject", target = "subjectDto")
    @Mapping(source = "subject.teacher", target = "subjectDto.teacherDto")
    ExamDto examToExamDto (Exam exam);
    List<ExamDto> examToExamDtos (List<Exam> exam);
}
