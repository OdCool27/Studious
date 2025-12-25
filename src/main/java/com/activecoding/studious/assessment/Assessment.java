package com.activecoding.studious.assessment;

import com.activecoding.studious.academic_task.AcademicTask;
import com.activecoding.studious.session.Session;

public class Assessment extends AcademicTask {
    private AssessmentType type;
    private Session duration;
    private String location;

    public enum AssessmentType {
        ONLINE, CLASSROOM, LAB, FINAL, OPEN_BOOK
    }

    //Constructor
    public Assessment(){
        super();
        this.type = null;
        this.duration = new Session();
        this.location = "";
    }

    public Assessment(AcademicTask parent, AssessmentType type, Session duration, String location){
        super(parent);
        this.type = type;
        this.duration = duration;
        this.location = location;
    }

    public Assessment(Assessment assessment){
        super(assessment);
        this.type = assessment.type;
        this.duration = assessment.duration;
        this.location = assessment.location;
    }


    //Accessors and Mutators
    public AssessmentType getType() {
        return type;
    }

    public void setType(AssessmentType type) {
        this.type = type;
    }

    public Session getDuration() {
        return duration;
    }

    public void setDuration(Session duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "Assessment{" +
                "taskID=" + taskID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", module=" + module +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", type=" + type +
                ", duration=" + duration +
                ", location='" + location + '\'' +
                '}';
    }
}
