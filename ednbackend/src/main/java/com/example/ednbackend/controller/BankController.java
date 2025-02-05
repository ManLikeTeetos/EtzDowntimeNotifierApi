package com.example.ednbackend.controller;

import com.example.ednbackend.models.Bank;
import com.example.ednbackend.service.BankService;
import com.example.ednbackend.dto.ResponseMessage;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/banks")
//@CrossOrigin(origins = "http://localhost:3000")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks() {
        return ResponseEntity.ok(bankService.getAllBanks());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addBank(@RequestBody Bank bank) {
        if (bankService.isBankNameExists(bank.getBankname())) {  // Check if bankname exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(new ResponseMessage("Bankname already exists!"));
        }

        bankService.saveBank(bank);
        return ResponseEntity.ok(new ResponseMessage("Bank entered successfully"));
    }
}
