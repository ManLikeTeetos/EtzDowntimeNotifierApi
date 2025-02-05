package com.example.ednbackend.service;

import com.example.ednbackend.models.Status;
import com.example.ednbackend.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    //Method to gell all Status
    public List<Status> getAllStatus(){
        return statusRepository.findAll();
    }

    //Method to check if Status exist
    public boolean isStatusExists(String message){
        Optional<Status> status = statusRepository.findByMessage(message);
        return status.isPresent();
    }


     // Method to save a new status
     public Status saveStatus(Status status) {  // Save method returning the saved entity
        return statusRepository.save(status);
    }

}