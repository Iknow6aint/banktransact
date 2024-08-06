package com.example.banktransaction.dto;

import lombok.Data;

@Data
public class AirtimeRequest {
    private String sourceAccount;
    private String networkProvider;
    private Double amount;
    private String phoneNumber;
}
