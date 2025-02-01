package com.example.ednbackend.models;

import jakarta.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Column(unique = true, nullable = false)
    private String message;

    // public Long getId() { return id; }
    // public void setId(Long id) { this.id = id; }

    // public String getCode() { return code; }
    // public void setCode(String code) { this.code = code; }

    // public String getMessage() { return message; }
    // public void setMessage(String message) { this.message = message; }
}
