package com.example.ednbackend.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalTime;

@Getter
@Setter
public class BankStatusRequest {
    private String bankname;
    private LocalTime downtime;
    private LocalTime uptime;
    private String status;
    private String reason;
    private String resolution;
}
