package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Преподаватель")
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/save")
    @ApiOperation("Сохранение")
    TeacherDto save(@RequestBody TeacherDto teacherDto){return teacherService.save(teacherDto);}

    @GetMapping("/findById")
    @ApiOperation("Поиск преподавателя по ID")
    TeacherDto findById(@RequestParam Long id)
    {return teacherService.findById(id);}

    @DeleteMapping ("/delete")
    @ApiOperation("Удаление")
    String  update(@RequestParam Long id){
        return teacherService.delete(id);}
}
