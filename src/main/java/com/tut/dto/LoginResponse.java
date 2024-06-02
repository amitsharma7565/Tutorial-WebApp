package com.tut.dto;

public class LoginResponse {
    private String token;
    private long expiresIn;
    private String message; // Add a message field for error messages

    // Default constructor
    public LoginResponse() {}

    // Constructor to set token and expiresIn
    public LoginResponse(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }

    // Constructor to set an error message
    public LoginResponse(String message) {
        this.message = message;
    }

    // Getters and setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
