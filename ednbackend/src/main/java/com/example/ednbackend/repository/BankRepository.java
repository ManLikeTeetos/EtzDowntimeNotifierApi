package com.example.ednbackend.repository;

import com.example.ednbackend.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
