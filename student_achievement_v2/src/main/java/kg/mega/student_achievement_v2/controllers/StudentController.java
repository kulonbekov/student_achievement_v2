package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kg.mega.student_achievement_v2.models.dtos.StudentDto;
import kg.mega.student_achievement_v2.services.StudentService;
import kg.mega.student_achievement_v2.services.SubjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Студент")
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;
    private final SubjectService subjectService;

    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }


    @PostMapping("/save")
    @ApiOperation("Сохранение")
    StudentDto save(@RequestBody StudentDto studentDto){
        studentDto = studentService.save(studentDto);
        studentDto.setSubjectDto(subjectService.findById(studentDto.getSubjectDto().getId()));
        return studentDto;
    }
    @GetMapping("/findById")
    @ApiOperation("Поиск студента по ID")
    StudentDto findById(@RequestParam Long id){
        return studentService.findById(id);
    }
}
