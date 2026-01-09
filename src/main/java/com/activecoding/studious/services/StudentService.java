package com.activecoding.studious.services;

import com.activecoding.studious.entities.Session;
import com.activecoding.studious.entities.Student;
import com.activecoding.studious.repositories.StudentRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository,  PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(UUID id){
        return studentRepository.findById(id);
    }

    public Student registerStudent(Student student){
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        // Hash password
        String hashedPassword = passwordEncoder.encode(student.getPasswordHash());
        student.setPasswordHash(hashedPassword);

        return studentRepository.save(student);
    }

    public Student loginStudent(String email, String password){

        Student student =  studentRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("Email or Password Invalid"));

        if(!passwordEncoder.matches(password,student.getPasswordHash())){
            throw new RuntimeException("Email or Password Invalid");
        }

        return student;
    }

    public Student updateStudent(UUID id, Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());

        // Hash password
        String hashedPassword = passwordEncoder.encode(studentDetails.getPasswordHash());
        student.setPasswordHash(hashedPassword);

        student.setSchool(studentDetails.getSchool());
        student.setCourse(studentDetails.getCourse());
        if(studentDetails.getTimetable() != null){
            student.setTimetable(studentDetails.getTimetable());
        }else{
            student.setTimetable(new HashSet<Session>());
        }

        return studentRepository.save(student);
    }

    public void deleteStudent(UUID id){
        studentRepository.deleteById(id);
    }

    public void deleteStudentByEmail(String email){
        studentRepository.deleteByEmail(email);
    }
}
