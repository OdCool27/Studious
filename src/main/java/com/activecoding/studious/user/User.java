package com.activecoding.studious.user;
import java.util.UUID;

public class User {
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String passwordHash;
    protected Role role;

    public enum Role {STUDENT, ADMIN, OTHER}

    //CONSTRUCTORS
    public User(){
        this.id = UUID.randomUUID();
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.passwordHash = "";
        this.role = Role.OTHER;
    }

    public User(UUID id, String firstName, String lastName, String email, String passwordHash, Role role){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public User(User user){
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.passwordHash = user.passwordHash;
        this.role = user.role;
    }

    //ACCESSORS AND MUTATORS
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", role=" + role +
                '}';
    }
}
