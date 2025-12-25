package com.activecoding.studious.module;
import com.activecoding.studious.session.Session;

import java.util.Arrays;
import java.util.UUID;

public class Module {
    private UUID moduleID;
    private String moduleName;
    private String moduleCode;
    private String moduleDescription;
    private String lecturer;
    private Session[] sessions;


    //Constructors
    public Module(){
        this.moduleID = UUID.randomUUID();
        this.moduleName = UUID.randomUUID().toString();
        this.moduleCode = UUID.randomUUID().toString();
        this.moduleDescription = UUID.randomUUID().toString();
        this.lecturer = UUID.randomUUID().toString();
        this.sessions = null;
    }

    public Module(UUID moduleID, String moduleName, String moduleCode, String moduleDescription, String lecturer){
        this.moduleID = moduleID;
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.moduleDescription = moduleDescription;
        this.lecturer = lecturer;
        this.sessions = null;
    }

    public Module(Module module){
        this.moduleID = module.moduleID;
        this.moduleName = module.moduleName;
        this.moduleCode = module.moduleCode;
        this.moduleDescription = module.moduleDescription;
        this.lecturer = module.lecturer;
        this.sessions = module.sessions;
    }

    //Accessors and Mutators
    public UUID getModuleID() {
        return moduleID;
    }

    public void setModuleID(UUID moduleID) {
        this.moduleID = moduleID;
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

    public Session[] getSessions() {
        return sessions;
    }

    public void setSessions(Session[] sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleID=" + moduleID +
                ", moduleName='" + moduleName + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleDescription='" + moduleDescription + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", sessions=" + Arrays.toString(sessions) +
                '}';
    }
}

