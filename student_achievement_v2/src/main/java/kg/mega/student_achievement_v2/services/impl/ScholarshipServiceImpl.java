package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ScholarshipRep;
import kg.mega.student_achievement_v2.mappers.ScholarshipMapper;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;
import kg.mega.student_achievement_v2.services.ScholarshipService;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    private final ScholarshipRep scholarshipRep;
    private final ScholarshipMapper scholarshipMapper;
    private final StudentService studentService;

    public ScholarshipServiceImpl(ScholarshipRep scholarshipRep, ScholarshipMapper scholarshipMapper, StudentService studentService) {
        this.scholarshipRep = scholarshipRep;
        this.scholarshipMapper = scholarshipMapper;
        this.studentService = studentService;
    }

    @Override
    public ScholarshipDto save(ScholarshipDto scholarshipDto) {
        Scholarship scholarship = scholarshipMapper.scholarshipDtoToEntity(scholarshipDto);
        scholarship = scholarshipRep.save(scholarship);
        scholarshipDto.setId(scholarship.getId());
        scholarshipDto.setStartDate(scholarship.getStartDate());
        scholarshipDto.setEndDate(scholarship.getEndDate());
        scholarshipDto.setStudentDto(studentService.findById(scholarship.getStudent().getId()));
        return scholarshipDto;
    }

    @Override
    public ScholarshipDto findById(Long id) {
        Scholarship scholarship = scholarshipRep.findById(id).orElseThrow(()->new RuntimeException("Стипендия не найдена"));
        ScholarshipDto scholarshipDto = scholarshipMapper.scholarshipToScholarshipDto(scholarship);
        return scholarshipDto;
    }
}
