package com.example.ednbackend.service;

import com.example.ednbackend.models.User;
import com.example.ednbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public boolean authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            // Compare the password using BCrypt
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false;
    }

      // Method to register a user with hashed password
     public boolean registerUser(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return false; // User already exists
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));  // Hash the password
        userRepository.save(user);
        return true;  // Registration successful
    }
}
