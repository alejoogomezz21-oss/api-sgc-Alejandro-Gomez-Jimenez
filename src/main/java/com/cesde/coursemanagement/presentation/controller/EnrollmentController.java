package com.cesde.coursemanagement.presentation.controller;

import com.cesde.coursemanagement.application.service.EnrollmentService;
import com.cesde.coursemanagement.domain.models.Enrollment;
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
    public List<Enrollment> list() {
        return enrollmentService.findAll();
    }

    @PostMapping
    public Enrollment save(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @GetMapping("/{id}")
    public Optional<Enrollment> getEnrollmentById(@PathVariable Long id) {
        return enrollmentService.findBId(id);
    }

    @PutMapping("/{id}")
    public Optional<Enrollment> update(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        enrollment.setId(id);
        return enrollmentService.update(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        enrollmentService.deleteById(id);
    }
}