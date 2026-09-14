package com.cesde.coursemanagement.application.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCourseDto(
        @NotBlank(message = "El nombre del curso es obligatorio")
        String name,
        String description
) {}