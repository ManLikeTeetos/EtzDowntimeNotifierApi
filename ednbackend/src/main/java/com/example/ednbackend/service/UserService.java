package com.example.ednbackend.service;

import com.example.ednbackend.dto.RegisterUserRequest;
import com.example.ednbackend.models.User;
import com.example.ednbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticate(String username,  String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {  // ✅ Fixed method call
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false;
    }

    // Register a user with hashed password
    public boolean registerUser(RegisterUserRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent() || 
            userRepository.findByEmail(request.getEmail()).isPresent()) {
            return false; // User already exists
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDepartment(request.getDepartment());
        user.setIsAdmin(request.isAdmin());  

        System.out.println("Is Admin: " + user.isAdmin());  //

        // Generate a generic password
        String genericPassword = "Etranzact123";  
        user.setPassword(passwordEncoder.encode(genericPassword));

        userRepository.save(user);
        return true;  // Registration successful
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    

    public List<User> getAllUsers() {
        Iterable<User> usersIterable = userRepository.findAll();
        return StreamSupport.stream(usersIterable.spliterator(), false)
                            .collect(Collectors.toList());
    }
}
