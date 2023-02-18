package kg.mega.student_achievement_v2.mappers;

import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ScholarshipMapper {

    ScholarshipMapper INSTANCE = Mappers.getMapper(ScholarshipMapper.class);

    @Mapping(source = "studentDto", target = "student")
    @Mapping(source = "studentDto.subjectDto", target = "student.subject")
    @Mapping(source = "studentDto.subjectDto.teacherDto", target = "student.subject.teacher")
    Scholarship scholarshipDtoToEntity (ScholarshipDto scholarshipDto);
    List<Scholarship> scholarshipDtoToEntities (List<ScholarshipDto> scholarshipDto);
    @Mapping(source = "student", target = "studentDto")
    @Mapping(source = "student.subject", target = "studentDto.subjectDto")
    @Mapping(source = "student.subject.teacher", target = "studentDto.subjectDto.teacherDto")
    ScholarshipDto scholarshipToScholarshipDto (Scholarship scholarship);
    List<ScholarshipDto> scholarshipToScholarshipDtos (List<Scholarship> scholarship);
}
