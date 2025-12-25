package com.activecoding.studious.student;

import com.activecoding.studious.user.User;

import java.util.Arrays;

public class Student extends User{
    private String school;
    private String course;
    private Module[] timetable;

    //Constructors
    public Student(){
        super();
        setRole(Role.STUDENT);
        school = "";
        course = "";
        timetable = null;
    }

    public Student(User user, String school, String course, Module[] timetable){
        super(user);
        setRole(Role.STUDENT);
        this.school = school;
        this.course = course;
        this.timetable = timetable;
    }

    public Student(Student student){
        super(student);
        setRole(Role.STUDENT);
        this.school = student.school;
        this.course = student.course;
        this.timetable = student.timetable;
    }

    //Accessors and Mutators
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

    public Module[] getTimetable() {
        return timetable;
    }

    public void setTimetable(Module[] timetable) {
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
                ", timetable=" + Arrays.toString(timetable) +
                '}';
    }
}
