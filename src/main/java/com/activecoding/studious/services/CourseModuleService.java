package com.activecoding.studious.services;

import com.activecoding.studious.entities.CourseModule;
import com.activecoding.studious.repositories.CourseModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseModuleService {

    private final CourseModuleRepository courseModuleRepository;

    public CourseModuleService(CourseModuleRepository courseModuleRepository) {
        this.courseModuleRepository = courseModuleRepository;
    }

    public List<CourseModule> findAll() {
        return courseModuleRepository.findAll();
    }
}
