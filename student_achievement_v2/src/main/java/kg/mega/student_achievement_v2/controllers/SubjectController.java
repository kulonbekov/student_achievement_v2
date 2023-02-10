package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.SubjectDto;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Предмет")
@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    SubjectDto save(@RequestBody SubjectDto subjectDto){return subjectService.save(subjectDto);}
}
