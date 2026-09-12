package com.cesde.coursemanagement.application.dto.response;

import com.cesde.coursemanagement.domain.models.Student;

import java.time.LocalDate;

public record StudentResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        LocalDate birthDate
) {
    public static StudentResponseDto from(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBirthDate()
        );
    }
}
