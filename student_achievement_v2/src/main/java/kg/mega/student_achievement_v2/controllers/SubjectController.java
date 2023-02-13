package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.services.SubjectService;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Предмет")
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService, TeacherService teacherService) {
        this.subjectService = subjectService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    SubjectDto save(@RequestBody SubjectDto subjectDto){
         subjectDto= subjectService.save(subjectDto);
        return subjectDto;
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск предмета по ID")
    SubjectDto findById(@RequestParam Long id){
        return subjectService.findById(id);}
}
