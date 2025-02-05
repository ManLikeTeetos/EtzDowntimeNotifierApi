package com.example.ednbackend.repository;

import com.example.ednbackend.models.BankStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BankStatusRepository extends JpaRepository<BankStatus, Long> {
    List<BankStatus> findByBankname(String bankname);
    List<BankStatus> findByBanknameAndDateCreatedBetween(String bankname, LocalDateTime startDate, LocalDateTime endDate);
}
