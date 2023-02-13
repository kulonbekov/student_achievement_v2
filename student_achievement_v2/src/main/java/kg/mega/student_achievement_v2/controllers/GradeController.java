package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.GradeDto;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.GradeService;
import kg.mega.student_achievement_v2.services.StudentService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Оценки")
@RestController
@RequestMapping("/api/v1/grade")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService, StudentService studentService, ExamService examService) {
        this.gradeService = gradeService;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
    GradeDto save(@RequestBody GradeDto gradeDto){
        gradeDto = gradeService.save(gradeDto);
        return gradeDto;
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск экзамена по ID")
    GradeDto findById (@RequestParam Long id){
        return gradeService.findById(id);
    }

}
