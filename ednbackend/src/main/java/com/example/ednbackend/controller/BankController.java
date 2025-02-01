package com.example.ednbackend.controller;

import com.example.ednbackend.models.Bank;
import com.example.ednbackend.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
//@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks() {
        return ResponseEntity.ok(bankRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
            bankRepository.save(bank);
            return ResponseEntity.ok(new ResponseMessage("Bank entered successfully"));
    }
}
