package com.example.ednbackend.controller;

import com.example.ednbackend.models.Reason;
import com.example.ednbackend.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ednbackend.dto.ResponseMessage;  

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
        reasonRepository.save(reason);
        return ResponseEntity.ok(new ResponseMessage("Reason entered successfully"));
    }
}
