package com.cesde.coursemanagement.application.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateEnrollmentDto(
        @NotNull(message = "El ID del estudiante es obligatorio")
        Long studentId,
        @NotNull(message = "El ID del curso es obligatorio")
        Long courseId,
        @NotNull(message = "La fecha de matrícula es obligatoria")
        LocalDate enrollmentDate,
        @NotNull(message = "El estado es obligatorio")
        String status
) {}