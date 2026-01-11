package com.activecoding.studious.controllers;

import com.activecoding.studious.dto.StudentLoginRequest;
import com.activecoding.studious.dto.StudentRegisterRequest;
import com.activecoding.studious.dto.StudentResponse;
import com.activecoding.studious.entities.Student;
import com.activecoding.studious.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody StudentRegisterRequest request) {
        try {
            Student student = studentService.registerStudent(request);
            return ResponseEntity.ok(new StudentResponse(student));

        } catch (RuntimeException e) {
            //If email is in use
            Map<String, String> error = new HashMap<>();
            error.put("status", "fail");
            error.put("message", e.getMessage());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody StudentLoginRequest request) {
        try {
            Student s = studentService.loginStudent(request);
            return ResponseEntity.ok(new StudentResponse(s));

        }catch (RuntimeException e) {
            //If email or password is incorrect
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    Map.of("status", "fail",  "message", e.getMessage())
            );
        }
    }
}
