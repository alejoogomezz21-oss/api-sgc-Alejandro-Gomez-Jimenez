package com.cesde.coursemanagement.presentation.controller;

import com.cesde.coursemanagement.application.dto.CreateCourseDto;
import com.cesde.coursemanagement.application.dto.UpdateCourseDto;
import com.cesde.coursemanagement.application.dto.response.CourseResponseDto;
import com.cesde.coursemanagement.domain.exception.CourseNotFoundException;
import com.cesde.coursemanagement.domain.models.Course;
import com.cesde.coursemanagement.application.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> list() {
        List<CourseResponseDto> response = courseService.findAll().stream()
                .map(CourseResponseDto::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> save(@RequestBody @Valid CreateCourseDto createDto) {
        Course course = new Course();
        course.setName(createDto.name());
        course.setDescription(createDto.description());
        course.setCode(createDto.code());
        course.setMaxCapacity(createDto.maxCapacity());

        Course saved = courseService.save(course);
        return new ResponseEntity<>(CourseResponseDto.from(saved), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return ResponseEntity.ok(CourseResponseDto.from(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> update(@PathVariable Long id, @RequestBody @Valid UpdateCourseDto updateDto) {
        Course course = new Course();
        course.setId(id);
        course.setName(updateDto.name());
        course.setDescription(updateDto.description());

        Course updated = courseService.update(course)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return ResponseEntity.ok(CourseResponseDto.from(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        courseService.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}