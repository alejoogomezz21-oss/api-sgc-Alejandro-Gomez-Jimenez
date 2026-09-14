package com.cesde.coursemanagement.application.dto.response;

import com.cesde.coursemanagement.domain.models.Course;

public record CourseResponseDto(
        Long id,
        String name,
        String description
) {
    public static CourseResponseDto from(Course course) {
        return new CourseResponseDto(
                course.getId(),
                course.getName(),
                course.getDescription()
        );
    }
}