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

    @PostMapping("/signin")
    public String signIn(@RequestBody LoginRequest request) {
        boolean authenticated = userService.authenticate(request.getEmail(), request.getPassword());
        return authenticated ? "Login Successful" : "Invalid Credentials";
    }
}
