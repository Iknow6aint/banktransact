package com.example.banktransaction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
@Data
public class Account {
    @Id
    private String id;
    private String accountNumber;
    private User user;
}
