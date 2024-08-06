package com.example.banktransaction.repository;

import com.example.banktransaction.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByAccountNumber(String accountNumber);

}
