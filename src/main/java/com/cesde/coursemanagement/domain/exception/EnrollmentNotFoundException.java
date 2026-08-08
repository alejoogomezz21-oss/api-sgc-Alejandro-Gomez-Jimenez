package com.cesde.coursemanagement.domain.exception;

public class EnrollmentNotFoundException extends BusinessException {
    public EnrollmentNotFoundException(Long id) {
        super("Enrollment not found: " + id);
    }
}
