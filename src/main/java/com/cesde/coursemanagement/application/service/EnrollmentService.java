package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.models.Enrollment;
import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment save(Enrollment enrollment);
    Optional<Enrollment> findByEnrollmentId(Long enrollmentId);
    Optional<Enrollment> findBId(Long id);
    List<Enrollment> findAll();
    boolean existsByEnrollmentId(Long enrollmentId);
    void deleteById(Long id);
    Optional<Enrollment> update(Enrollment enrollment);
}