package com.example.ednbackend.repository;

import com.example.ednbackend.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
