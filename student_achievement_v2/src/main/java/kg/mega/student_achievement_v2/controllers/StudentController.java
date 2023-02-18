package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.models.responses.StudentResponse;
import kg.mega.student_achievement_v2.services.StudentService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Студент")
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
    }


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    StudentDto save(@RequestBody StudentDto studentDto){
        studentDto = studentService.save(studentDto);
        return studentDto;
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск студента по ID")
    StudentDto findById(@RequestParam Long id){
        return studentService.findById(id);
    }

    @GetMapping("/findAll")
    @ApiOperation("Вывод всех студентов")
    ResponseEntity<List<StudentDto>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/getByStudent")
    @ApiOperation("Вывод инфо о студенте")
    StudentResponse findByStudent(@RequestParam Long id){
        return studentService.getByStudent(id);
    }

}
