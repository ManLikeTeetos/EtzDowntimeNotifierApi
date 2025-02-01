package com.example.ednbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.ednbackend.dto.LoginRequest;
import com.example.ednbackend.service.UserService;
import com.example.ednbackend.dto.ResponseMessage;  // New Response DTO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "https://reimagined-spork-954jr96v4ggcpqrg-3000.app.github.dev") // Enable CORS for this controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseMessage register(@RequestBody LoginRequest request) {
        boolean registered = userService.registerUser(request.getEmail(), request.getPassword());
        if (registered) {
            return new ResponseMessage("Registration Successful");
        } else {
            return new ResponseMessage("User Already Exist");
        }
    }

    // Sign In Endpoint
    @PostMapping("/signin")
    public ResponseMessage signIn(@RequestBody LoginRequest request) {
        boolean authenticated = userService.authenticate(request.getEmail(), request.getPassword());
        if (authenticated) {
            return new ResponseMessage("Login Successful");
        } else {
            return new ResponseMessage("Invalid Credentials");
        }
    }
}
