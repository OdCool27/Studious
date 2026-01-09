package com.activecoding.studious.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID session_id;

    @ManyToOne(optional = false)
    @JoinColumn(name="moduleID")
    private CourseModule courseModule;

    @Column(nullable = false)
    private Day dayOfTheWeek;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @OneToMany(mappedBy = "timetable")
    private List<Student> students;


    public enum Day{
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public Session(){}

    public Session(CourseModule courseModule, Day dayOfTheWeek, LocalTime startTime, LocalTime endTime){
        this.courseModule = courseModule;
        this.dayOfTheWeek = dayOfTheWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public CourseModule getModule() {
        return courseModule;
    }

    public void setModule(CourseModule courseModule) {
        this.courseModule = courseModule;
    }

    public Day getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(Day dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + session_id +
                ", courseModule=" + courseModule +
                ", dayOfTheWeek=" + dayOfTheWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
