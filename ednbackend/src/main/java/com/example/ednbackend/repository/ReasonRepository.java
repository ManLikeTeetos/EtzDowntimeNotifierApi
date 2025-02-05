package com.example.ednbackend.repository;

import com.example.ednbackend.models.Reason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReasonRepository extends JpaRepository<Reason, Long> {
    Optional<Reason> findByMessage(String message);
}
