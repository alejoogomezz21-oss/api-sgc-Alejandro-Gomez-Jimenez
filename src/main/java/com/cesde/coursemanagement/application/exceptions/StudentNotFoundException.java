package com.cesde.coursemanagement.application.exceptions;

public class StudentNotFoundException extends BusinessException {

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Long id) {

        super("Student not found: " + id);
    }

}