package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.models.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    @Mapping(source = "teacherDto", target = "teacher")
    Subject subjectDtoToEntity (SubjectDto subjectDto);
    List<Subject> subjectDtoToEntities (List<SubjectDto> subjectDto);

    @Mapping(source = "teacher", target = "teacherDto")
    SubjectDto subjectToSubjectDto (Subject subject);
    List<SubjectDto> subjectToSubjectDtos (List<Subject> subject);
}
