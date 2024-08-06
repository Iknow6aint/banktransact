package com.example.banktransaction.repository;

import com.example.banktransaction.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    // Custom method to find transactions by source account and date range
    List<Transaction> findBySourceAccountAndDateBetween(String sourceAccount, LocalDateTime start, LocalDateTime end);
    List<Transaction> findBySourceAccount(String sourceAccount);
}
