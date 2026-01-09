package com.activecoding.studious.repositories;

import com.activecoding.studious.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    public void deleteByEmail(String email);

    public boolean existsByEmail(String email);

    public Optional<Student> findByEmail(String email);
}
