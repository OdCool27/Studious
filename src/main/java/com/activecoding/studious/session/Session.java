package com.activecoding.studious.session;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Session {
    private UUID sessionID;
    private String location;
    private DayOfTheWeek day;
    private LocalTime startTime;
    private LocalTime endTime;

    public enum DayOfTheWeek {
        MONDAY,  TUESDAY, WEDNESDAY, THURSDAY,  FRIDAY, SATURDAY, SUNDAY
    }


    //Constructors
    public Session(){
        this.sessionID = UUID.randomUUID();
        this.location = "";
        this.day = null;
        this.startTime = LocalTime.now();
        this.endTime = LocalTime.now().plusMinutes(60);
    }

    public Session(String location, DayOfTheWeek day, LocalTime startTime, LocalTime endTime){
        this.sessionID = UUID.randomUUID();
        this.location = location;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Session(Session session){
        this.sessionID = session.sessionID;
        this.location = session.location;
        this.day = session.day;
        this.startTime = session.startTime;
        this.endTime = session.endTime;
    }


    //Accessors and Mutators
    public UUID getSessionID() {
        return sessionID;
    }

    public void setSessionID(UUID sessionID) {
        this.sessionID = sessionID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DayOfTheWeek getDay() {
        return day;
    }

    public void setDay(DayOfTheWeek day) {
        this.day = day;
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
                "sessionID=" + sessionID +
                ", location='" + location + '\'' +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
