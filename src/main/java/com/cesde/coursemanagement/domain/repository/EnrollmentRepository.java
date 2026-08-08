package com.cesde.coursemanagement.domain.repository;

import com.cesde.coursemanagement.domain.models.Enrollment;
import com.cesde.coursemanagement.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    Enrollment save(Enrollment enrollment);

    Optional<Enrollment> findByEnrollmentId(Long enrollmentId);

    Optional<Enrollment> findBId(Long id);

    List<Enrollment> findAll();

    boolean existsByEnrollmentId(Long enrollmentId);

    void deleteById(Long id);

    Optional<Enrollment> update(Enrollment enrollment);
}
