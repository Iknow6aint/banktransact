package com.example.banktransaction.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private Usertype userType; // BUSINESS or RETAIL
    private LocalDate joinDate;
    private List<Account> accounts; // Assuming a user can have multiple accounts

    public String getAccountNumber() {
        if (accounts != null && !accounts.isEmpty()) {
            return accounts.get(0).getAccountNumber(); // You might want to change this logic based on your needs
        }
        return null;
    }
}
