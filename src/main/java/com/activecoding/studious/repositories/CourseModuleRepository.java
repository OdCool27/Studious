package com.activecoding.studious.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.activecoding.studious.entities.CourseModule;
import java.util.UUID;

public interface CourseModuleRepository extends JpaRepository<CourseModule, UUID> {

}
