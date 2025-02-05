package com.example.ednbackend.dto;

public class BankStatusRequest {
    private String bankname;
    private String downtime;
    private String uptime;
    private String status;
    private String reason;
    private String resolution;

    // Getters and Setters
    public String getBankname() { return bankname; }
    public void setBankname(String bankname) { this.bankname = bankname; }

    public String getDowntime() { return downtime; }
    public void setDowntime(String downtime) { this.downtime = downtime; }

    public String getUptime() { return uptime; }
    public void setUptime(String uptime) { this.uptime = uptime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getResolution() { return resolution; }
    public void setResolution(String resolution) { this.resolution = resolution; }
}
