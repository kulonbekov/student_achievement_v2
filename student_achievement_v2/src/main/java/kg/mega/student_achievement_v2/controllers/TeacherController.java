package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.dtos.TeacherDto;
import kg.mega.student_achievement_v2.models.entities.Teacher;
import kg.mega.student_achievement_v2.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<?> findById(@RequestParam Long id) {
        TeacherDto teacherDto = null;
        try{
            teacherDto = teacherService.findById(id);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(teacherDto);
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех преподавателей")
    ResponseEntity<List<TeacherDto>> findAll(){
        return ResponseEntity.ok(teacherService.findAll());
    }

    @DeleteMapping ("/delete")
    @ApiOperation("Удаление")
    ResponseEntity<?> delete(@RequestParam Long id){
        return teacherService.delete(id);}

    @PutMapping("/update")
    @ApiOperation("Изменения")
    ResponseEntity<?> update(@RequestBody TeacherDto teacherDto){
        try{
            return ResponseEntity.ok(teacherService.update(teacherDto));
        }catch (Exception e){
            return ResponseEntity.status(404).body("Teacher not found, cannot be updated!");
        }

    }



}
