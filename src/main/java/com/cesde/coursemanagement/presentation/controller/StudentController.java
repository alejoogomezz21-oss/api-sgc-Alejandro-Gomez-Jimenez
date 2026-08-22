package com.cesde.coursemanagement.presentation.controller;


import com.cesde.coursemanagement.domain.models.Student;
import com.cesde.coursemanagement.domain.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping
    public Student getStudentById(@RequestParam Long id) {
        return studentRepository.findById(id).get();
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PatchMapping
    public Student patch(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
