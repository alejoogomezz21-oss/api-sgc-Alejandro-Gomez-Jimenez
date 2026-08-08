package com.cesde.coursemanagement.domain.repository;

import com.cesde.coursemanagement.domain.models.Course;
import com.cesde.coursemanagement.domain.models.Enrollment;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Course save(Course course);

    Optional<Course> findByCourseId(Long courseId);

    Optional<Course> findBId(Long id);

    List<Course> findAll();

    boolean existsByCourseId(Long courseId);

    void deleteById(Long id);

    Optional<Course> update(Course course);
}
