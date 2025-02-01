package com.example.ednbackend.controller;

import com.example.ednbackend.models.Status;
import com.example.ednbackend.repository.StatusRepository;
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
        statusRepository.save(status);
        return ResponseEntity.ok(new ResponseMessage("Status entered successfully"));
    }
}
