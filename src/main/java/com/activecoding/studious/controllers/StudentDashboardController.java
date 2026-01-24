package com.activecoding.studious.controllers;

import com.activecoding.studious.dto.StudentResponse;
import com.activecoding.studious.services.StudentService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentDashboardController {

    private final StudentService studentService;

    public StudentDashboardController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student_dashboard")
    public String studentDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model){
        String email =  userDetails.getUsername();
        StudentResponse student = studentService.getStudentByEmail(email);

        model.addAttribute("student", student);
        return "student_dashboard";
    }
}
