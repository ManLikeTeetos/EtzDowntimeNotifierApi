package com.example.ednbackend.service;

import com.example.ednbackend.models.Reason;
import com.example.ednbackend.repository.BankRepository;
import com.example.ednbackend.repository.ReasonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReasonService {
    @Autowired
    private ReasonRepository reasonRepository;

    //Method to gell all Reason
    public List<Reason> getAllReasons(){
        return reasonRepository.findAll();
    }

    //Method to check if reason exist
    public boolean isReasonExists(String message){
        Optional<Reason> reason = reasonRepository.findByMessage(message);
        return reason.isPresent();
    }


     // Method to save a new reason
     public Reason saveReason(Reason reason) {  // Save method returning the saved entity
        return reasonRepository.save(reason);
    }

}