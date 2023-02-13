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

    public ScholarshipController(ScholarshipService scholarshipService, StudentService studentService) {
        this.scholarshipService = scholarshipService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ScholarshipDto save(@RequestBody ScholarshipDto scholarshipDto){
        scholarshipDto = scholarshipService.save(scholarshipDto);
        return scholarshipDto;
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск стипендии по ID")
    ScholarshipDto findById(@RequestParam Long id){
        return scholarshipService.findById(id);
    }

}
