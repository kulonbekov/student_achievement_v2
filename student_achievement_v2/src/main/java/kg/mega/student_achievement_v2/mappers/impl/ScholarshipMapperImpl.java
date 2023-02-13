package kg.mega.student_achievement_v2.mappers.impl;

import kg.mega.student_achievement_v2.dao.ScholarshipRep;
import kg.mega.student_achievement_v2.mappers.ScholarshipMapper;
import kg.mega.student_achievement_v2.mappers.StudentMapper;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;
import org.springframework.stereotype.Service;

@Service
public class ScholarshipMapperImpl implements ScholarshipMapper {
    private final StudentMapper studentMapper;
    private final ScholarshipRep scholarshipRep;

    public ScholarshipMapperImpl(StudentMapper studentMapper,
                                 ScholarshipRep scholarshipRep) {
        this.studentMapper = studentMapper;
        this.scholarshipRep = scholarshipRep;
    }

    @Override
    public Scholarship scholarshipDtoToEntity(ScholarshipDto scholarshipDto) {
        Scholarship scholarship = new Scholarship();
        scholarship.setId(scholarshipDto.getId());
        scholarship.setScholarshipAmount(scholarshipDto.getScholarshipAmount());
        scholarship.setStartDate(scholarshipDto.getStartDate());
        scholarship.setEndDate(scholarshipDto.getEndDate());

        scholarship.setStudent(studentMapper.studentDtoToEntity(scholarshipDto.getStudentDto()));
        return scholarship;
    }

    @Override
    public ScholarshipDto scholarshipToScholarshipDto(Scholarship scholarship) {
        ScholarshipDto scholarshipDto = new ScholarshipDto();
        scholarshipDto.setId(scholarship.getId());
        scholarshipDto.setScholarshipAmount(scholarship.getScholarshipAmount());
        scholarshipDto.setStartDate(scholarship.getStartDate());
        scholarshipDto.setEndDate(scholarship.getEndDate());

        scholarshipDto.setStudentDto(studentMapper.studentToStudentDto(scholarship.getStudent()));
        return scholarshipDto;
    }
}
