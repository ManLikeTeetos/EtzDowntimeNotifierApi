package com.example.ednbackend.models;

import javax.annotation.processing.Generated;

import jakarta.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankname;
    private String type;
    private String downtime;
    private String status;
    private String reason;

    // public Long getId() { return id;}
    // public void setId(Long id){ this.id = id; }

    // public String getBankname() { return bankname; }
    // public void setBankname(String bankname) { this.bankname = bankname; }

    // public String getType() { return type; }
    // public void setType(String type) { this.type = type; }

    // public String getDowntime() { return downtime; }
    // public void setDowntime(String downtime) { this.downtime = downtime; }

    // public String getStatus() { return status; }
    // public void setStatus(String status) { this.status = status; }

    // public String getReason() { return reason; }
    // public void setReason(String reason) { this.reason = reason; }

    // public String getResolution() { return resolution; }
    // public void setResolution(String resolution) { this.resolution = resolution; }
    
}