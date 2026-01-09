package com.activecoding.studious.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@DiscriminatorValue("STUDENT")
public class Student extends User {

    //Accessors and Mutators
    @Column(nullable=false)
    private String school;

    @Column(nullable=false)
    private String course;

    @ManyToMany
    @JoinTable(
            name = "timetable",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private Set<Session> timetable = new HashSet<>();

    //Constructors
    protected Student(){
        super();
    }

    public Student(String firstName, String lastName, String email, String passwordHash, String school, String course, Set<Session> timetable){
        super(firstName, lastName, email, passwordHash);
        //setRole(Role.STUDENT);
        this.school = school;
        this.course = course;
        this.timetable = timetable;
    }

    public Student(Student student){
        super(student);
        //setRole(Role.STUDENT);
        this.school = student.school;
        this.course = student.course;
        this.timetable = student.timetable;
    }

    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Set<Session> getTimetable() {
        return timetable;
    }

    public void setTimetable(Set<Session> timetable) {
        this.timetable = timetable;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                ", school='" + school + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
