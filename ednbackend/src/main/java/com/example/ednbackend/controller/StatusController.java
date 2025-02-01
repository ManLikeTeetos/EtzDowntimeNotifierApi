package com.example.controller;

import com.example.models.Status;
import com.example.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
//@CrossOrigin(origins = "http://localhost:3000")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public ResponseEntity<List<Status>> getStatuses() {
        return ResponseEntity.ok(statusRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Status> addStatus(@RequestBody Status status) {
        return ResponseEntity.ok(statusRepository.save(status));
    }
}
