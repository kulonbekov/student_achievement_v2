package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.ScholarshipDto;
import kg.mega.student_achievement_v2.services.ScholarshipService;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Стипендия")
@RestController
@RequestMapping("/api/v1/scholarship")
public class ScholarshipController {
    private final ScholarshipService scholarshipService;
    private final StudentService studentService;

    public ScholarshipController(ScholarshipService scholarshipService, StudentService studentService) {
        this.scholarshipService = scholarshipService;
        this.studentService = studentService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ScholarshipDto save(@RequestBody ScholarshipDto scholarshipDto){
        scholarshipDto = scholarshipService.save(scholarshipDto);
        scholarshipDto.setStudentDto(studentService.findById(scholarshipDto.getStudentDto().getId()));
        scholarshipDto.setEndDate(scholarshipDto.getEndDate());
        scholarshipDto.setStartDate(scholarshipDto.getStartDate());
        return scholarshipDto;
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск стипендии по ID")
    ScholarshipDto findById(@RequestParam Long id){
        return scholarshipService.findById(id);
    }


    /*@PostMapping("/save")
    @ApiOperation("Сохранение")
    ExamDto save(@RequestBody ExamDto examDto){
        examDto = examService.save(examDto);
        examDto.setSubjectDto(subjectService.findById(examDto.getSubjectDto().getId()));
        return examDto;
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск экзамена по ID")
    ExamDto findById(@RequestParam Long id){
        return examService.findById(id);
    }*/
}
