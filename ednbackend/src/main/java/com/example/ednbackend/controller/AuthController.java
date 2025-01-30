package com.example.ednbackend.controller;

import com.example.ednbackend.dto.LoginRequest;
import com.example.ednbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public String register(@RequestBody LoginRequest request) {
        boolean registered = userService.registerUser(request.getEmail(), request.getPassword());
        return registered ? "Registration Successful" : "Registration Failed";
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody LoginRequest request) {
        boolean authenticated = userService.authenticate(request.getEmail(), request.getPassword());
        return authenticated ? "Login Successful" : "Invalid Credentials";
    }
}
