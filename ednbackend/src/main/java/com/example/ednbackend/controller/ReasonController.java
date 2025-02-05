package com.example.ednbackend.controller;

import com.example.ednbackend.models.Reason;
import com.example.ednbackend.service.ReasonService;
import com.example.ednbackend.repository.ReasonRepository;
import com.example.ednbackend.dto.ResponseMessage;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/reasons")
//@CrossOrigin(origins = "http://localhost:3000")
public class ReasonController {

    @Autowired
    private ReasonService reasonService;

    @GetMapping
    public ResponseEntity<List<Reason>> getReasons() {
        return ResponseEntity.ok(reasonService.getAllReasons());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addReason(@RequestBody Reason reason) {
        if(reasonService.isReasonExists(reason.getMessage())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new ResponseMessage("Reason already exists!"));
        }


        reasonService.saveReason(reason);
        return ResponseEntity.ok(new ResponseMessage("Reason entered successfully"));
    }
}
