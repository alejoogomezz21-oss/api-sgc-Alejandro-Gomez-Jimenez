package com.cesde.coursemanagement.domain.exception;

public class StudentNotFoundException extends ResourceNotFoundException {

    public StudentNotFoundException(Long id) {

        super("Student not found: " + id);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

}