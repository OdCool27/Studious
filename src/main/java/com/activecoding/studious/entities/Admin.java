package com.activecoding.studious.entities;

import java.util.ArrayList;

public class Admin extends User {
    private String adminID;
    private ArrayList<Permission> permissions;

    public enum Permission {CREATE_MODULE, EDIT_MODULE, DELETE_MODULE, UPDATE_ACCOUNT, DELETE_ACCOUNT}

    //Constructors
    public Admin(){
        super();
        //setRole(Role.ADMIN);
        adminID = "";
        permissions = null;
    }

    public Admin(User user, String adminID, ArrayList<Permission> permissions){
        super(user);
        //setRole(Role.ADMIN);
        this.adminID = adminID;
        this.permissions = permissions;
    }

    public Admin(Admin admin){
        super(admin);
        //setRole(Role.ADMIN);
        this.adminID = admin.adminID;
        this.permissions = admin.permissions;
    }

    //Accessors and Mutators
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                ", adminID='" + adminID + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
