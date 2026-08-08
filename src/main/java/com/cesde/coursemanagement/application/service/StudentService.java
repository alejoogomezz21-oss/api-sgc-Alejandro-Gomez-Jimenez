package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.StudentNotFoundException;
import com.cesde.coursemanagement.domain.models.Student;
import com.cesde.coursemanagement.domain.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService implements StudentRepository {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, StudentRepository studentRepository1) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student save(Student student) {
        if (studentRepository.existsByStudentId(student.getId())) {
            throw new StudentNotFoundException("Student with id: " + student.getId() + " not found");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new StudentNotFoundException("Student with email: " + student.getEmail() + " not found");
        }
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findByStudentId(Long studentId) {
        if (studentRepository.findByStudentId(studentId).isEmpty()) {
            throw new RuntimeException("no Student with student id " + studentId);
        }
        return studentRepository.findByStudentId(studentId);
    }

    @Override
    public Optional<Student> findBId(Long id) {
        return studentRepository.findBId(id);
    }

    @Override
    public List<Student> findAll() {
        if (studentRepository.findAll().isEmpty()) {
            throw new StudentNotFoundException("");
        }
        return studentRepository.findAll();
    }

    @Override
    public boolean existsByStudentId(Long studentId) {
        if (studentRepository.existsByStudentId(studentId)) {
            throw new StudentNotFoundException("Student with id: " + studentId + " not found");
        }
        return studentRepository.existsByStudentId(studentId);
    }

    @Override
    public void deleteById(Long id) {
        if (studentRepository.existsByStudentId(id)) {
            throw new StudentNotFoundException("Student with id: " + id + " not found");
        }
        studentRepository.deleteById(id);

    }

    @Override
    public Optional<Student> update(Student student) {

        if (studentRepository.existsByStudentId(student.getId())) {
            throw new StudentNotFoundException("Student with id: " + student.getId() + " not found");
        }
        return studentRepository.update(student);
    }

    @Override
    public boolean existsByEmail(String email) {
        if (studentRepository.existsByEmail(email)) {
            throw new StudentNotFoundException("Student with email: " + email + " not found");
        }
        return studentRepository.existsByEmail(email);
    }
}
