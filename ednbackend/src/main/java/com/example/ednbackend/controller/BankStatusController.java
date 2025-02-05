package com.example.ednbackend.controller;

import com.example.ednbackend.dto.BankStatusRequest;
import com.example.ednbackend.models.BankStatus;
import com.example.ednbackend.service.BankStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.List;

@RestController
@RequestMapping("/api/bank-status")
public class BankStatusController {
    @Autowired
    private BankStatusService bankStatusService;

    // Add a new bank status (Each update creates a new entry)
    @PostMapping("/add")
    public BankStatus addBankStatus(@RequestBody BankStatusRequest request) {
        return bankStatusService.addBankStatus(request);
    }

    // Get all bank statuses
    @GetMapping("/all")
    public List<BankStatus> getAllBankStatuses() {
        return bankStatusService.getAllBankStatuses();
    }

    // Get bank statuses by bank name
    @GetMapping("/{bankname}")
    public List<BankStatus> getBankStatusesByBankname(@PathVariable String bankname) {
        return bankStatusService.getBankStatusesByBankname(bankname);
    }

    // Get bank statuses by bank name and date range
    @GetMapping("/{bankname}/by-date")
    public List<BankStatus> getBankStatusesByDateRange(
            @PathVariable String bankname,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDateTime start = LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        return bankStatusService.getBankStatusesByDateRange(bankname, start, end);
    }

@GetMapping("/{bankname}/latest")
public BankStatus getLatestBankStatus(@PathVariable String bankname) {
    LocalDate today = LocalDate.now();
    LocalDateTime startOfDay = today.atStartOfDay();
    LocalDateTime endOfDay = today.atTime(LocalTime.MAX);

    return bankStatusService.getLatestBankStatus(bankname, startOfDay, endOfDay);
}


    // Delete a bank status entry by ID
    @DeleteMapping("/{id}")
    public void deleteBankStatus(@PathVariable Long id) {
        bankStatusService.deleteBankStatus(id);
    }
}
