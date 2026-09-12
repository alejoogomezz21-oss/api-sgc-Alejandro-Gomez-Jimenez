package com.cesde.coursemanagement.domain.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(
        name = "enrollment"
)

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El estudiante es obligatorio")
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Aquí usamos el objeto Course
    @NotNull(message = "El curso es obligatorio")
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotNull(message = "La fecha de matrícula es obligatoria")
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @NotNull(message = "El estado es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private EnrollmentStatus status;

    public Enrollment() {}

    public Enrollment(Long id, Long studentId, Long courseId, LocalDate enrollmentDate, EnrollmentStatus status) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return student.getId();
    }

    public void setStudentId(Long studentId) {
        this.student = student;
    }

    public Long getCourseId() {
        return course.getId();
    }

    public void setCourseId(Long courseId) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", studentId=" + student +
                ", courseId=" + course +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                '}';
    }
}
