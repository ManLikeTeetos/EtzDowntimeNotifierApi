package com.example.ednbackend.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_status")
public class BankStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bankname;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime downtime;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime uptime;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String resolution;

    @Column(nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBankname() { return bankname; }
    public void setBankname(String bankname) { this.bankname = bankname; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalTime getDowntime() { return downtime; }
    public void setDowntime(LocalTime downtime) { this.downtime = downtime; }

    public LocalTime getUptime() { return uptime; }
    public void setUptime(LocalTime uptime) { this.uptime = uptime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }

    public LocalDateTime getDateCreated() { return dateCreated; }
}
