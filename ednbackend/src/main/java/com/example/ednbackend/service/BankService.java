package com.example.ednbackend.service;

import com.example.ednbackend.models.Bank;
import com.example.ednbackend.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    // Method to get all banks
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    // Method to check if bankname already exists
    public boolean isBankNameExists(String bankname) {
        Optional<Bank> bank = bankRepository.findByBankname(bankname);
        return bank.isPresent();
    }

    // Method to save a new bank
    public Bank saveBank(Bank bank) {  // Save method returning the saved entity
        return bankRepository.save(bank);
    }
}
