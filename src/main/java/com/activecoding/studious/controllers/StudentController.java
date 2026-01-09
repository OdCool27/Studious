package com.activecoding.studious.controllers;

import com.activecoding.studious.entities.Student;
import com.activecoding.studious.services.StudentService;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, @RequestParam String school, @RequestParam String course) {
        try {
            Student s = new Student(firstName, lastName, email, password, school, course, new HashSet<>());
            studentService.registerStudent(s);
            Map<String, Object> studentResponse = getStringObjectMap(s);
            return ResponseEntity.ok(studentResponse);

        } catch (RuntimeException e) {
            //If email is in use
            Map<String, String> error = new HashMap<>();
            error.put("status", "fail");
            error.put("message", e.getMessage());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            Student s = studentService.loginStudent(email, password);
            Map<String, Object> studentResponse = getStringObjectMap(s);

            return ResponseEntity.ok(studentResponse);

        }catch (RuntimeException e) {
            //If email or password is incorrect
            Map<String, String> error = new HashMap<>();
            error.put("status", "fail");
            error.put("message", e.getMessage());
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }

    private static @NonNull Map<String, Object> getStringObjectMap(Student s) {
        Map<String, Object> studentResponse = new HashMap<>();
        studentResponse.put("firstName", s.getFirstName());
        studentResponse.put("lastName", s.getLastName());
        studentResponse.put("email", s.getEmail());
        studentResponse.put("school", s.getSchool());
        studentResponse.put("course", s.getCourse());
        studentResponse.put("status", "success");
        return studentResponse;
    }
}
