package com.activecoding.studious.services;

import com.activecoding.studious.dto.StudentLoginRequest;
import com.activecoding.studious.dto.StudentRegisterRequest;
import com.activecoding.studious.dto.StudentResponse;
import com.activecoding.studious.entities.Session;
import com.activecoding.studious.entities.Student;
import com.activecoding.studious.repositories.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository,  PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //USER DETAILS SERVICE
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Student not found for email: " + email));
        return student; // Student implements UserDetails
    }


    //CONVERTS A REQUEST DTO TO A STUDENT OBJECT FOR PERSISTENCE
    public Student convertRequest(StudentRegisterRequest request) {
        return new Student(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(),
                "", request.getSchool(), request.getCourse(), new HashSet<>());
    }



    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(UUID id){
        return studentRepository.findById(id);
    }

    public StudentResponse getStudentByEmail(String email){
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Student not found for email: " + email
                ));
        return new StudentResponse(student);
    }

    public Student registerStudent(StudentRegisterRequest request){
        if(studentRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        var student = convertRequest(request);//Converts a request into a student entity
        student.setPasswordHash(passwordEncoder.encode(student.getPasswordHash()));//Encodes password and stores hash

        return studentRepository.save(student);
    }




    public Student loginStudent(StudentLoginRequest request){

        Student student =  studentRepository.findByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("Email or Password Invalid"));

        if(!passwordEncoder.matches(request.getPassword(),student.getPasswordHash())){
            throw new RuntimeException("Email or Password Invalid");
        }

        return student;
    }




    public Student updateStudent(UUID id, Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found"));

        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setProfilePicURL(studentDetails.getProfilePicURL());

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
