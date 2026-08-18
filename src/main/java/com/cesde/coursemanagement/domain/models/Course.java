package com.cesde.coursemanagement.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código del curso no puede estar vacío")
    @Column(unique = true, nullable = false, length = 50)
    private String code;

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    @Column(nullable = false, length = 150)
    private String name;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(nullable = false, length = 250)
    private String description;

    @NotNull(message = "La capacidad máxima es obligatoria")
    @Column(name = "max_capacity", nullable = false)
    private Integer maxCapacity;

        public Course() {}

        public Course(Long id, String code, String name, String description, Integer maxCapacity) {
            this.id = id;
            this.code = code;
            this.name = name;
            this.description = description;
            this.maxCapacity = maxCapacity;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getMaxCapacity() {
            return maxCapacity;
        }

        public void setMaxCapacity(Integer maxCapacity) {
            this.maxCapacity = maxCapacity;
        }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

