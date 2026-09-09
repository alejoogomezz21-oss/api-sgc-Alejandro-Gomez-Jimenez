package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student save(Student student);
    Optional<Student> findByStudentId(Long studentId);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    boolean existsByStudentId(Long studentId);
    boolean existsByEmail(String email);
    void deleteById(Long id);
    Optional<Student> update(Student student);
}