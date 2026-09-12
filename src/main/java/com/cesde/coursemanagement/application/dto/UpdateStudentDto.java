package com.cesde.coursemanagement.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record UpdateStudentDto(

        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
        String firstName,

        @NotBlank(message = "El apellido no puede estar vacío")
        @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
        String lastName,

        @NotBlank(message = "El correo electrónico no puede estar vacío")
        @Email(message = "El formato del correo electrónico no es válido")
        @Size(max = 150, message = "El correo electrónico no puede exceder los 150 caracteres")
        String email,

        @NotNull(message = "La fecha de nacimiento es obligatoria")
        LocalDate birthDate
) {
}