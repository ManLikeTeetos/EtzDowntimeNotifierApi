package com.example.ednbackend.repository;

import com.example.ednbackend.models.Reason;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ReasonRepository extends JpaRepository<Reason, Long> {
    Optional<Reason> findByMessage(String message);
}
