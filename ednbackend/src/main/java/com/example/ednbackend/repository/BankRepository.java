package com.example.ednbackend.repository;

import com.example.ednbackend.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<Bank> findByBankname(String bankname);
}
