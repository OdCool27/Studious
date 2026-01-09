package com.activecoding.studious.entities;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="modules")
public class CourseModule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID moduleID;

    @Column(nullable = false, unique = true)
    private String moduleName;

    @Column(nullable = false, unique = true)
    private String moduleCode;

    private String moduleDescription;

    private String lecturer;


    //Constructors
    protected CourseModule(){}

    public CourseModule(String moduleName, String moduleCode, String moduleDescription, String lecturer){
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.moduleDescription = moduleDescription;
        this.lecturer = lecturer;
    }


    // Accessors and Mutators
    public UUID getModuleID() {
        return moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "CourseModule{" +
                "moduleID=" + moduleID +
                ", moduleName='" + moduleName + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleDescription='" + moduleDescription + '\'' +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }
}


