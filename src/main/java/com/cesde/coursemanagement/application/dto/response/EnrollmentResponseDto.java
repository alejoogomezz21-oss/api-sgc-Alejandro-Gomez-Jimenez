package com.cesde.coursemanagement.application.dto.response;

import com.cesde.coursemanagement.domain.models.Enrollment;

public record EnrollmentResponseDto(
        Long id,
        StudentResponseDto student,
        CourseResponseDto course,
        String status
) {
    public static EnrollmentResponseDto from(Enrollment enrollment) {
        return new EnrollmentResponseDto(
                enrollment.getId(),
                enrollment.getStudent() != null ? StudentResponseDto.from(enrollment.getStudent()) : null,
                enrollment.getCourse() != null ? CourseResponseDto.from(enrollment.getCourse()) : null,
                enrollment.getStatus() != null ? enrollment.getStatus().name() : null
        );
    }
}