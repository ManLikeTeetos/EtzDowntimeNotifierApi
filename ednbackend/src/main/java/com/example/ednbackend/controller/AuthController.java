package com.example.ednbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.ednbackend.models.User;
import com.example.ednbackend.dto.LoginRequest;
import com.example.ednbackend.dto.RegisterUserRequest;
import com.example.ednbackend.dto.UserResponse;
import com.example.ednbackend.service.UserService;
import com.example.ednbackend.dto.ResponseMessage;  // New Response DTO
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@CrossOrigin(origins = "https://reimagined-spork-954jr96v4ggcpqrg-3000.app.github.dev") // Enable CORS for this controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<ResponseMessage> register(@RequestBody RegisterUserRequest request) {
        boolean registered = userService.registerUser(request);
        if (registered) {
            return ResponseEntity.ok( new ResponseMessage("Registration Successful"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body( new ResponseMessage("User Already Exist"));
        }
    }

   // Sign In Endpoint
   @PostMapping("/signin")
   public ResponseEntity<?> signIn(@RequestBody LoginRequest request) {
    boolean authenticated = userService.authenticate(request.getUsername(), request.getPassword());
    if (authenticated) {
        // Fetch user details after successful authentication
        User user = userService.findByUsername(request.getUsername());
        
        if (user != null) {
            return ResponseEntity.ok(new UserResponse(user, "Login Successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(new ResponseMessage("User not found"));
        }
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                             .body(new ResponseMessage("Invalid Credentials"));
    }
}

   // **GET all users (Only Admins)**
   @GetMapping("/users")
   public ResponseEntity<?> getAllUsers(@RequestParam String adminUsername) {
       User adminUser = userService.findByUsername(adminUsername);
       if (adminUser == null || !adminUser.isAdmin()) {
           return ResponseEntity.status(403).body(new ResponseMessage("Access Denied: Admins only"));
       }
       
       List<User> users = userService.getAllUsers();
       return ResponseEntity.ok(users);
   }
}
