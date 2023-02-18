package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.dao.ExamRep;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.services.ExamService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Экзамен")
@RestController
@RequestMapping("/api/v1/exam")
public class ExamController {

    private final ExamService examService;
    private final ExamRep examRep;

    public ExamController(ExamService examService, SubjectService subjectService,
                          ExamRep examRep) {
        this.examService = examService;
        this.examRep = examRep;
    }

    @PostMapping("/save")
    @ApiOperation("Сохранение")
   ResponseEntity<?> save(@RequestBody ExamDto examDto){
        return examService.save(examDto);
    }

    @GetMapping("/findById")
    @ApiOperation("Поиск экзамена по ID")
    ExamDto findById(@RequestParam Long id){
        return examService.findById(id);
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех экзаменов")
    ResponseEntity<List<ExamDto>> findAll(){
        return ResponseEntity.ok(examService.findAll());
    }
}
