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


    // 1. GET PRINCIPAL: Trae toda la lista. Funciona perfecto.
    @GetMapping
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}
