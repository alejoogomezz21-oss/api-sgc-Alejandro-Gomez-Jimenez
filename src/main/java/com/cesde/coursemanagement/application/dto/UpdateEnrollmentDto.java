package com.cesde.coursemanagement.application.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateEnrollmentDto(
        @NotNull(message = "El ID del estudiante es obligatorio")
        Long studentId,
        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId,
        String status
) {}