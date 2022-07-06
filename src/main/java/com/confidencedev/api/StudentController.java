package com.confidencedev.api;

import com.confidencedev.auth.models.Login;
import com.confidencedev.models.Student;
import com.confidencedev.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/school")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public String addMovie(@RequestBody Login login) {
        return studentService.validateLogin(login);
    }

    @PostMapping
    public void addMovie(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @GetMapping
    public List<Student> studentList() {
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getMovieId(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @PutMapping("{id}")
    public void updateMovie(@PathVariable("id") Integer id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }
}
