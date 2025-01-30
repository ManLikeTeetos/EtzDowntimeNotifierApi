package com.example.ednbackend.dto;

public class ResponseMessage {

    private String message;

    // Constructor
    public ResponseMessage(String message) {
        this.message = message;
    }

    // Getter and Setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
