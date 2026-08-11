package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.EnrollmentNotFoundException;
import com.cesde.coursemanagement.domain.models.Enrollment;
import com.cesde.coursemanagement.domain.repository.EnrollmentRepository;


import java.util.List;
import java.util.Optional;

public class EnrollmentService implements EnrollmentRepository {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getId() != null && enrollmentRepository.existsByEnrollmentId(enrollment.getId())) {
            throw new RuntimeException("Enrollment with id: " + enrollment.getId() + " already exists");
        }
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Optional<Enrollment> findByEnrollmentId(Long enrollmentId) {
        if (enrollmentRepository.findByEnrollmentId(enrollmentId).isEmpty()) {
            throw new EnrollmentNotFoundException(enrollmentId);
        }
        return enrollmentRepository.findByEnrollmentId(enrollmentId);
    }

    @Override
    public Optional<Enrollment> findBId(Long id) {
        return enrollmentRepository.findBId(id);
    }

    @Override
    public List<Enrollment> findAll() {
        if (enrollmentRepository.findAll().isEmpty()) {
            throw new RuntimeException("No enrollments found");
        }
        return enrollmentRepository.findAll();
    }

    @Override
    public boolean existsByEnrollmentId(Long enrollmentId) {
        if (!enrollmentRepository.existsByEnrollmentId(enrollmentId)) {
            throw new EnrollmentNotFoundException(enrollmentId);
        }
        return enrollmentRepository.existsByEnrollmentId(enrollmentId);
    }

    @Override
    public void deleteById(Long id) {
        if (!enrollmentRepository.existsByEnrollmentId(id)) {
            throw new EnrollmentNotFoundException(id);
        }
        enrollmentRepository.deleteById(id);
    }

    @Override
    public Optional<Enrollment> update(Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findByEnrollmentId(enrollment.getId())
                .orElseThrow(() -> new EnrollmentNotFoundException(enrollment.getId()));

        existingEnrollment.setStudentId(enrollment.getStudentId());
        existingEnrollment.setCourseId(enrollment.getCourseId());
        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        existingEnrollment.setStatus(enrollment.getStatus());

        return enrollmentRepository.update(existingEnrollment);
    }
}