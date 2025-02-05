package com.example.ednbackend.service;

import com.example.ednbackend.dto.BankStatusRequest;
import com.example.ednbackend.models.BankStatus;
import com.example.ednbackend.repository.BankStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BankStatusService {
    @Autowired
    private BankStatusRepository bankStatusRepository;

    public BankStatus addBankStatus(BankStatusRequest request) {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate(); // Extract only the date part
        LocalDateTime startOfDay = today.atStartOfDay(); // Convert to LocalDateTime at 00:00
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX); // C

        // Check if an entry with the same bankname and today’s date exists
        Optional<BankStatus> existingStatus = bankStatusRepository.findLatestByBankname(request.getBankname(), startOfDay, endOfDay);

        if (existingStatus.isPresent() && request.getUptime() != null) {
            // If uptime is provided and an existing entry is found for today, update it
            BankStatus bankStatus = existingStatus.get();
            // Preserve the downtime and update the uptime
            bankStatus.setUptime(request.getUptime());
            bankStatus.setStatus(request.getStatus());
            bankStatus.setReason(request.getReason());
            bankStatus.setResolution(request.getResolution());
            return bankStatusRepository.save(bankStatus);
        } else {
            // Otherwise, create a new entry
            BankStatus newStatus = new BankStatus();
            newStatus.setBankname(request.getBankname());
            newStatus.setDowntime(request.getDowntime());
            newStatus.setUptime(request.getUptime() != null ? request.getUptime() : LocalTime.of(0, 0)); // Default uptime to 00:00 if not provided
            newStatus.setStatus(request.getStatus());
            newStatus.setReason(request.getReason());
            newStatus.setResolution(request.getResolution());
            return bankStatusRepository.save(newStatus);
        }
    }
    
    // Get all bank status updates
    public List<BankStatus> getAllBankStatuses() {
        return bankStatusRepository.findAll();
    }

    // Get bank status updates by bank name
    public List<BankStatus> getBankStatusesByBankname(String bankname) {
        return bankStatusRepository.findByBankname(bankname);
    }

    //Get latest bank

    public BankStatus getLatestBankStatus(String bankname, LocalDateTime start, LocalDateTime end) {
        Optional<BankStatus> latestStatus = bankStatusRepository.findLatestByBankname(bankname, start, end);
        return latestStatus.orElse(null);  // Return null if no status is found
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
