package com.cesde.coursemanagement.application.service;

import com.cesde.coursemanagement.domain.exception.StudentNotFoundException;
import com.cesde.coursemanagement.domain.models.Student;
import com.cesde.coursemanagement.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        if (student.getId() != null && studentRepository.existsById(student.getId())) {
            throw new RuntimeException("Student with id: " + student.getId() + " already exists");
        }

        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Student with email: " + student.getEmail() + " already exists");
        }

        return studentRepository.save(student);
    }

    public Optional<Student> findByStudentId(Long studentId) {
        if (studentRepository.findById(studentId).isEmpty()) {
            throw new StudentNotFoundException("no Student with student id " + studentId);
        }
        return studentRepository.findById(studentId);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        if (studentRepository.findAll().isEmpty()) {
            throw new StudentNotFoundException("No students found");
        }
        return studentRepository.findAll();
    }

    public boolean existsByStudentId(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new StudentNotFoundException("Student with id: " + studentId + " not found");
        }
        return studentRepository.existsById(studentId);
    }

    public boolean existsByEmail(String email) {
        if (!studentRepository.existsByEmail(email)) {
            throw new StudentNotFoundException("Student with email: " + email + " not found");
        }
        return studentRepository.existsByEmail(email);
    }

    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student with id: " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

    public Optional<Student> update(Student student) {
        Student existingStudent = studentRepository.findById(student.getId())
                .orElseThrow(() -> new StudentNotFoundException("Estudiante no encontrado con id: " + student.getId()));

        if (!existingStudent.getEmail().equals(student.getEmail())) {
            if (studentRepository.existsByEmail(student.getEmail())) {
                throw new IllegalArgumentException("El correo ingresado ya pertenece a otro estudiante.");
            }
        }

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBirthDate(student.getBirthDate());

        return Optional.of(studentRepository.save(existingStudent));
    }
}