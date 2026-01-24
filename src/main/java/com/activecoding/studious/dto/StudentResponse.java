package com.activecoding.studious.dto;

import com.activecoding.studious.entities.Student;

public class StudentResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicURL;
    private String school;
    private String course;
    private String status;

    public StudentResponse(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.school = student.getSchool();
        this.course = student.getCourse();
        this.profilePicURL = student.getProfilePicURL();
        this.status = "success";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public String getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }
}
