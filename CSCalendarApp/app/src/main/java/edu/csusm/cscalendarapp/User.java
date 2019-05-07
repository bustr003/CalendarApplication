package edu.csusm.cscalendarapp;

import java.util.UUID;

public class User {
    String userCode = UUID.randomUUID().toString();
    String userEmail;
    String password;
    String firstName;
    String lastName;

    public User(String userEmail, String password, String firstName, String lastName) {
        this.userEmail = userEmail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
