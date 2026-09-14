package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);
    Optional<Course> findByCourseId(Long courseId);
    Optional<Course> findById(Long id);
    List<Course> findAll();
    boolean existsByCourseId(Long courseId);
    void deleteById(Long id);
    Optional<Course> update(Course course);
}