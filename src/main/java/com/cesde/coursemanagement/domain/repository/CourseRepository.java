package com.cesde.coursemanagement.domain.repository;

import com.cesde.coursemanagement.domain.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Si necesitas buscar por el código del curso:
    Optional<Course> findByCode(String code);

    boolean existsByCode(String code);
}