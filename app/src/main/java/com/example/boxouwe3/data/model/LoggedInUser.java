package com.example.boxouwe3.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }


    public String getuserId() {
        return this.userId;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}