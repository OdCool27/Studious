package com.activecoding.studious.assignment;

import com.activecoding.studious.academic_task.AcademicTask;

public class Assignment extends AcademicTask {
    private Platform externalPlatform;
    private String submissionNotes;

    public enum Platform{
        GOOGLE_CLASSROOM, MOODLE, EMAIL
    }

    //Constructor
    public Assignment(){
        super();
        this.externalPlatform = null;
        this.submissionNotes = null;
    }

    public Assignment (AcademicTask academicTask, Platform platform, String submissionNotes){
        super(academicTask);
        this.externalPlatform = platform;
        this.submissionNotes = submissionNotes;
    }

    public Assignment (Assignment assignment) {
        super(assignment);
        this.externalPlatform = assignment.externalPlatform;
        this.submissionNotes = assignment.submissionNotes;
    }

    //Accessors and Mutators
    public Platform getExternalPlatform() {
        return externalPlatform;
    }

    public void setExternalPlatform(Platform externalPlatform) {
        this.externalPlatform = externalPlatform;
    }

    public String getSubmissionNotes() {
        return submissionNotes;
    }

    public void setSubmissionNotes(String submissionNotes) {
        this.submissionNotes = submissionNotes;
    }


    @Override
    public String toString() {
        return "Assignment{" +
                "taskID=" + taskID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", module=" + module +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", externalPlatform=" + externalPlatform +
                ", submissionNotes='" + submissionNotes + '\'' +
                '}';
    }
}
