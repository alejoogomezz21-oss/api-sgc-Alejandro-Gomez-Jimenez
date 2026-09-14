package com.cesde.coursemanagement.domain.exception;

public class CourseAlreadyExistsException extends ResourceAlreadyExistsException {
    public CourseAlreadyExistsException(String message) {
        super(message);
    }
}
