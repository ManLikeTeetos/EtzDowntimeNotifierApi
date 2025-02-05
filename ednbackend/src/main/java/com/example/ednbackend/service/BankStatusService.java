package com.example.ednbackend.service;

import com.example.ednbackend.dto.BankStatusRequest;
import com.example.ednbackend.models.BankStatus;
import com.example.ednbackend.repository.BankStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankStatusService {
    @Autowired
    private BankStatusRepository bankStatusRepository;

    // Add a new bank status entry (Each update creates a new entry)
    public BankStatus addBankStatus(BankStatusRequest request) {
        BankStatus bankStatus = new BankStatus();
        bankStatus.setBankname(request.getBankname());
        bankStatus.setDowntime(LocalTime.parse(request.getDowntime()));
        bankStatus.setUptime(LocalTime.parse(request.getUptime()));
        bankStatus.setStatus(request.getStatus());
        bankStatus.setReason(request.getReason());
        bankStatus.setResolution(request.getResolution());
        return bankStatusRepository.save(bankStatus);
    }

    // Get all bank status updates
    public List<BankStatus> getAllBankStatuses() {
        return bankStatusRepository.findAll();
    }

    // Get bank status updates by bank name
    public List<BankStatus> getBankStatusesByBankname(String bankname) {
        return bankStatusRepository.findByBankname(bankname);
    }

    // Get bank status updates by bank name and date range
    public List<BankStatus> getBankStatusesByDateRange(String bankname, LocalDateTime startDate, LocalDateTime endDate) {
        return bankStatusRepository.findByBanknameAndDateCreatedBetween(bankname, startDate, endDate);
    }

    // Delete a bank status entry by ID
    public void deleteBankStatus(Long id) {
        bankStatusRepository.deleteById(id);
    }
}
