package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.EnrollmentNotFoundException;
import com.cesde.coursemanagement.domain.models.Enrollment;
import com.cesde.coursemanagement.domain.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getId() != null && enrollmentRepository.existsById(enrollment.getId())) {
            throw new RuntimeException("Enrollment with id: " + enrollment.getId() + " already exists");
        }
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Optional<Enrollment> findByEnrollmentId(Long id) {
        if (enrollmentRepository.findById(id).isEmpty()) {
            throw new EnrollmentNotFoundException(id);
        }
        return enrollmentRepository.findById(id);
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public List<Enrollment> findAll() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        if (enrollments.isEmpty()) {
            throw new RuntimeException("No enrollments found");
        }
        return enrollments;
    }

    @Override
    public boolean existsByEnrollmentId(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException(id);
        }
        return enrollmentRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException(id);
        }
        enrollmentRepository.deleteById(id);
    }

    @Override
    public Optional<Enrollment> update(Enrollment enrollment) {
        Enrollment existingEnrollment = enrollmentRepository.findById(enrollment.getId())
                .orElseThrow(() -> new EnrollmentNotFoundException(enrollment.getId()));

        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());
        existingEnrollment.setEnrollmentDate(enrollment.getEnrollmentDate());
        existingEnrollment.setStatus(enrollment.getStatus());

        Enrollment updated = enrollmentRepository.save(existingEnrollment);
        return Optional.of(updated);
    }
}