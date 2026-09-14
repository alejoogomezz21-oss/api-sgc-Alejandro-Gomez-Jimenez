package com.cesde.coursemanagement.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseDto(
        @NotBlank(message = "El nombre es obligatorio")
        String name,
        @NotBlank(message = "La descripción es obligatoria")
        String description,
        @NotBlank(message = "El código es obligatorio")
        String code,
        @NotNull(message = "La capacidad es obligatoria")
        Integer maxCapacity
) {}
