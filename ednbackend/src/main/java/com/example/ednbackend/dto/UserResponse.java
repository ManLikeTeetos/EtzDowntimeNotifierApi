package com.example.ednbackend.dto;

import com.example.ednbackend.models.User;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String firstname;
    private String lastname;
    private String department;
    private boolean isAdmin;
    private String message;

    // Constructor for easy initialization
    public UserResponse(User user, String message) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.department = user.getDepartment();
        this.isAdmin = user.isAdmin();
        this.message = message;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getDepartment() { return department; }
    public boolean isAdmin() { return isAdmin; }
    public String getMessage() { return message; }
}
