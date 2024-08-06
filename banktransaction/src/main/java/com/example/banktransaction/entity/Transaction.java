package com.example.banktransaction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transactions")
@Data
public class Transaction {
    @Id
    private String id;
    private String sourceAccount;
    private String destinationAccount;
    private Double amount;
    private String transactionType; // TRANSFER or AIRTIME
    private LocalDateTime date;
}
