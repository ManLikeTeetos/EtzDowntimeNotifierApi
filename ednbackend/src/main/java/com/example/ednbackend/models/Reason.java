package com.example.ednbackend.models;

import jakarta.persistence.*;

@Entity
public class Reason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String message;

    // public Long getId() { return id; }
    // public void setId(Long id) { this.id = id; }

    // public String getMessage() { return message; }
    // public void setMessage(String message) { this.message = message; }
}
