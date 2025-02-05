package com.example.ednbackend.repository;

import com.example.ednbackend.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findByMessage(String message);
}
