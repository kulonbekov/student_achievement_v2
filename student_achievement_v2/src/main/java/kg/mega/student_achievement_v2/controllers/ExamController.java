package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Экзамен")
@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {

    private final ExamService examService;
    public ExamController(ExamService examService, SubjectService subjectService) {
        this.examService = examService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    ExamDto save(@RequestBody ExamDto examDto){
        examDto = examService.save(examDto);
        return examDto;
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск экзамена по ID")
    ExamDto findById(@RequestParam Long id){
        return examService.findById(id);
    }
}
