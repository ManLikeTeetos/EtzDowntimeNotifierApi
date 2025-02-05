package com.example.ednbackend.controller;

import com.example.ednbackend.models.Status;
import com.example.ednbackend.service.StatusService;
import com.example.ednbackend.repository.StatusRepository;
import com.example.ednbackend.dto.ResponseMessage;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/status")
//@CrossOrigin(origins = "http://localhost:3000")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public ResponseEntity<List<Status>> getStatuses() {
        return ResponseEntity.ok(statusService.getAllStatus());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addStatus(@RequestBody Status status) {
        if(statusService.isStatusExists(status.getMessage())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ResponseMessage("Status already exists!"));
        }

        statusService.saveStatus(status);
        return ResponseEntity.ok(new ResponseMessage("Status entered successfully"));
    }
}
