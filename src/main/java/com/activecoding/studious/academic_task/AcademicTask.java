package com.activecoding.studious.academic_task;

import com.activecoding.studious.module.Module;

import java.time.LocalDateTime;
import java.util.UUID;

public class AcademicTask {
    protected UUID taskID;
    protected String title;
    protected String description;
    protected LocalDateTime dueDate;
    protected Module module;
    protected Status status;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public enum Status {PENDING, IN_PROGRESS, COMPLETED }

    //Constructor
    public AcademicTask() {
        this.taskID = UUID.randomUUID();
        this.title = "";
        this.description = "";
        this.dueDate = LocalDateTime.now();
        this.module = null;
        this.status = Status.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AcademicTask(UUID taskID,  String title, String description, LocalDateTime dueDate, Module module, Status status) {
        this.taskID = taskID;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.module = module;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public AcademicTask(AcademicTask academicTask) {
        this.taskID = academicTask.taskID;
        this.title = academicTask.title;
        this.description = academicTask.description;
        this.dueDate = academicTask.dueDate;
        this.module = academicTask.module;
        this.status = academicTask.status;
        this.createdAt = academicTask.createdAt;
        this.updatedAt = academicTask.updatedAt;
    }

    //Accessors and Mutators
    public UUID getTaskID() {
        return taskID;
    }

    public void setTaskID(UUID taskID) {
        this.taskID = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "AcademicTask{" +
                "taskID=" + taskID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", module=" + module +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
