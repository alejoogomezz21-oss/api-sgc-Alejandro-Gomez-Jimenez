package com.cesde.coursemanagement.domain.repository;

import com.cesde.coursemanagement.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);

    Optional<Student> findByStudentId(Long studentId);

    Optional<Student> findBId(Long id);

    List<Student> findAll();

    boolean existsByStudentId(Long studentId);

    void deleteById(Long id);

    Optional<Student> update(Student student);

    boolean existsByEmail(String email);
}
