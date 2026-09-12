package com.cesde.coursemanagement.domain.repository;

import com.cesde.coursemanagement.domain.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    // Como tu campo se llama 'id', usamos findById y existsById (que ya vienen en JpaRepository,
    // pero si quieres declararlos explícitamente, usa 'Id' con la I mayúscula).
    Optional<Enrollment> findById(Long id);

    boolean existsById(Long id);
}