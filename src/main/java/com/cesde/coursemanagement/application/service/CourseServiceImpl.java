package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.CourseNotFoundException;
import com.cesde.coursemanagement.domain.models.Course;
import com.cesde.coursemanagement.domain.repository.CourseRepository;

import java.util.List;
import java.util.Optional;


public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        if (course.getId() != null && courseRepository.existsByCourseId(course.getId())) {
            throw new RuntimeException("Course with id: " + course.getId() + " already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findByCourseId(Long courseId) {
        if (courseRepository.findByCourseId(courseId).isEmpty()) {
            throw new CourseNotFoundException(courseId);
        }
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public Optional<Course> findBId(Long id) {
        return courseRepository.findBId(id);
    }

    @Override
    public List<Course> findAll() {
        if (courseRepository.findAll().isEmpty()) {
            throw new RuntimeException("No courses found");
        }
        return courseRepository.findAll();
    }

    @Override
    public boolean existsByCourseId(Long courseId) {
        if (!courseRepository.existsByCourseId(courseId)) {
            throw new CourseNotFoundException(courseId);
        }
        return courseRepository.existsByCourseId(courseId);
    }

    @Override
    public void deleteById(Long id) {
        if (!courseRepository.existsByCourseId(id)) {
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> update(Course course) {
        Course existingCourse = courseRepository.findByCourseId(course.getId())
                .orElseThrow(() -> new CourseNotFoundException(course.getId()));

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setMaxCapacity(course.getMaxCapacity());

        return courseRepository.update(existingCourse);
    }
}