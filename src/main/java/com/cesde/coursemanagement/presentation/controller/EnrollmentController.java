package com.cesde.coursemanagement.presentation.controller;

import com.cesde.coursemanagement.application.dto.CreateEnrollmentDto;
import com.cesde.coursemanagement.application.dto.UpdateEnrollmentDto;
import com.cesde.coursemanagement.application.dto.response.EnrollmentResponseDto;
import com.cesde.coursemanagement.application.service.EnrollmentService;
import com.cesde.coursemanagement.domain.exception.EnrollmentNotFoundException;
import com.cesde.coursemanagement.domain.models.Course;
import com.cesde.coursemanagement.domain.models.Enrollment;
import com.cesde.coursemanagement.domain.models.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> list() {
        List<EnrollmentResponseDto> response = enrollmentService.findAll().stream()
                .map(EnrollmentResponseDto::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> save(@RequestBody @Valid CreateEnrollmentDto createDto) {
        Enrollment enrollment = new Enrollment();

        Student student = new Student();
        student.setId(createDto.studentId());
        enrollment.setStudent(student);

        Course course = new Course();
        course.setId(createDto.courseId());
        enrollment.setCourse(course);

        enrollment.setEnrollmentDate(createDto.enrollmentDate());
        enrollment.setStatus(com.cesde.coursemanagement.domain.models.EnrollmentStatus.valueOf(createDto.status()));

        Enrollment saved = enrollmentService.save(enrollment);
        return new ResponseEntity<>(EnrollmentResponseDto.from(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDto> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
        return ResponseEntity.ok(EnrollmentResponseDto.from(enrollment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateEnrollmentDto updateDto) {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(id);

        Student student = new Student();
        student.setId(updateDto.studentId());
        enrollment.setStudent(student);

        Course course = new Course();
        course.setId(updateDto.courseId());
        enrollment.setCourse(course);

        Enrollment updated = enrollmentService.update(enrollment)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
        return ResponseEntity.ok(EnrollmentResponseDto.from(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        enrollmentService.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException(id));
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}