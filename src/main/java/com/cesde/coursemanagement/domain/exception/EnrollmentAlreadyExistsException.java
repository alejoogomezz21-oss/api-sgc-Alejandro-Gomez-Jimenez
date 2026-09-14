package com.cesde.coursemanagement.domain.exception;

public class EnrollmentAlreadyExistsException extends ResourceAlreadyExistsException {
    public EnrollmentAlreadyExistsException(String message) {
        super(message);
    }
}
