package com.cesde.coursemanagement.presentation.controller;

import com.cesde.coursemanagement.application.service.CourseService;
import com.cesde.coursemanagement.domain.models.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> list() {
        return courseService.findAll();
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable Long id) {
        return courseService.findBId(id);
    }

    @PutMapping("/{id}")
    public Optional<Course> update(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.update(course);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }
}