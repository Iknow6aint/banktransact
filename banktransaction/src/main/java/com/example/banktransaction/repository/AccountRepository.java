package com.example.banktransaction.repository;

import com.example.banktransaction.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
