package com.cesde.coursemanagement.presentation.controller;

import com.cesde.coursemanagement.application.dto.CreateStudentDto;
import com.cesde.coursemanagement.application.dto.UpdateStudentDto;
import com.cesde.coursemanagement.application.dto.response.StudentResponseDto;
import com.cesde.coursemanagement.application.service.StudentService;
import com.cesde.coursemanagement.domain.models.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> list() {
        List<Student> students = studentService.findAll();

        List<StudentResponseDto> responseDtos = students.stream()
                .map(StudentResponseDto::from)
                .toList();

        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> save(@RequestBody @Valid CreateStudentDto createDto) {
        Student student = new Student();
        student.setFirstName(createDto.firstName());
        student.setLastName(createDto.lastName());
        student.setEmail(createDto.email());
        student.setBirthDate(createDto.birthDate());

        Student savedStudent = studentService.save(student);

        return new ResponseEntity<>(StudentResponseDto.from(savedStudent), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        return ResponseEntity.ok(StudentResponseDto.from(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateStudentDto updateDto) {
        Student student = new Student();
        student.setId(id);
        student.setFirstName(updateDto.firstName());
        student.setLastName(updateDto.lastName());
        student.setEmail(updateDto.email());
        student.setBirthDate(updateDto.birthDate());

        Student updatedStudent = studentService.update(student)
                .orElseThrow(() -> new RuntimeException("No se pudo actualizar el estudiante"));

        return ResponseEntity.ok(StudentResponseDto.from(updatedStudent));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}