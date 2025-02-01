package com.example.controller;

import com.example.model.Reason;
import com.example.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reasons")
//@CrossOrigin(origins = "http://localhost:3000")
public class ReasonController {

    @Autowired
    private ReasonRepository reasonRepository;

    @GetMapping
    public ResponseEntity<List<Reason>> getReasons() {
        return ResponseEntity.ok(reasonRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Reason> addReason(@RequestBody Reason reason) {
        return ResponseEntity.ok(reasonRepository.save(reason));
    }
}
