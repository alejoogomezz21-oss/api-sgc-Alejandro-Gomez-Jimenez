package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.CourseNotFoundException;
import com.cesde.coursemanagement.domain.models.Course;
import com.cesde.coursemanagement.domain.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course save(Course course) {
        if (course.getId() != null && courseRepository.existsById(course.getId())) { // Cambiado a existsById
            throw new RuntimeException("Course with id: " + course.getId() + " already exists");
        }
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findByCourseId(Long courseId) {
        if (courseRepository.findById(courseId).isEmpty()) { // Cambiado a findById
            throw new CourseNotFoundException(courseId);
        }
        return courseRepository.findById(courseId); // Cambiado a findById
    }

    @Override
    public Optional<Course> findBId(Long id) {
        return courseRepository.findById(id);
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
        if (!courseRepository.existsById(courseId)) { // Cambiado a existsById
            throw new CourseNotFoundException(courseId);
        }
        return courseRepository.existsById(courseId);
    }

    @Override
    public void deleteById(Long id) {
        if (!courseRepository.existsById(id)) { // Cambiado de existsByCourseId a existsById
            throw new CourseNotFoundException(id);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public Optional<Course> update(Course course) {
        // Buscamos usando el id real de la entidad
        Course existingCourse = courseRepository.findById(course.getId())
                .orElseThrow(() -> new CourseNotFoundException(course.getId()));

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setMaxCapacity(course.getMaxCapacity());
        // Si también manejas el código:
        existingCourse.setCode(course.getCode());

        return Optional.of(courseRepository.save(existingCourse));
    }
}