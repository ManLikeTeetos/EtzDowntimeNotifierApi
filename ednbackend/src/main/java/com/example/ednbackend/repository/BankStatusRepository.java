package com.example.ednbackend.repository;

import com.example.ednbackend.models.BankStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BankStatusRepository extends JpaRepository<BankStatus, Long> {

    List<BankStatus> findByBankname(String bankname);

    List<BankStatus> findByBanknameAndDateCreatedBetween(String bankname, LocalDateTime start, LocalDateTime end);

    // Find the latest entry for a bank within the same day, without considering time
    @Query(value = "SELECT * FROM bank_status WHERE bankname = :bankname AND date_created >= :startOfDay AND date_created <= :endOfDay ORDER BY date_created DESC LIMIT 1", nativeQuery = true)
    Optional<BankStatus> findLatestByBankname(@Param("bankname") String bankname, @Param("startOfDay") LocalDateTime startOfDay, @Param("endOfDay") LocalDateTime endOfDay);
}
