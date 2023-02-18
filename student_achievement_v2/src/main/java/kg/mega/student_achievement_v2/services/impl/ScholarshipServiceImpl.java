package kg.mega.student_achievement_v2.services.impl;

import kg.mega.student_achievement_v2.dao.ScholarshipRep;
import kg.mega.student_achievement_v2.mappers.ScholarshipMapper;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.models.entities.Scholarship;
import kg.mega.student_achievement_v2.services.ScholarshipService;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScholarshipServiceImpl implements ScholarshipService {

    private final ScholarshipRep scholarshipRep;

    private final StudentService studentService;

    public ScholarshipServiceImpl(ScholarshipRep scholarshipRep, StudentService studentService) {
        this.scholarshipRep = scholarshipRep;
        this.studentService = studentService;
    }

    @Override
    public ScholarshipDto save(ScholarshipDto scholarshipDto) {
        Scholarship scholarship = ScholarshipMapper.INSTANCE.scholarshipDtoToEntity(scholarshipDto);
        changeEndDate(scholarship.getStudent().getId());
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
        ScholarshipDto scholarshipDto = ScholarshipMapper.INSTANCE.scholarshipToScholarshipDto(scholarship);
        return scholarshipDto;
    }

    @Override
    public List<ScholarshipDto> findAll() {
        return ScholarshipMapper.INSTANCE.scholarshipToScholarshipDtos(scholarshipRep.findAll());
    }

    @Override
    public void changeEndDate(Long id) {
        List<Scholarship> oldScholarship = scholarshipRep.findByStudentId(id);
        for (Scholarship item: oldScholarship) {
            if(item.getEndDate().after(new Date())){
                item.setEndDate(new Date());
                save(ScholarshipMapper.INSTANCE.scholarshipToScholarshipDto(item));
            }

        }
    }
}
