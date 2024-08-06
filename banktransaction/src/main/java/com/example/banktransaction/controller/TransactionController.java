package com.example.banktransaction.controller;

import com.example.banktransaction.dto.AirtimeRequest;
import com.example.banktransaction.dto.TransferRequest;
import com.example.banktransaction.entity.Transaction;
import com.example.banktransaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> doTransfer(@RequestBody TransferRequest request) {
        Transaction transaction = transactionService.doTransfer(request.getSourceAccount(), request.getDestinationAccount(), request.getAmount());
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/airtime")
    public ResponseEntity<Transaction> buyAirtime(@RequestBody AirtimeRequest request) {
        Transaction transaction = transactionService.buyAirtime(request.getSourceAccount(), request.getNetworkProvider(), request.getAmount(), request.getPhoneNumber());
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/history/{accountNumber}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable String accountNumber) {
        List<Transaction> transactions = transactionService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(transactions);
    }
}
