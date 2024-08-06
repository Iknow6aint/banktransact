package com.example.banktransaction.util;

import com.example.banktransaction.entity.Transaction;
import com.example.banktransaction.entity.User;
import com.example.banktransaction.entity.Usertype;
import com.example.banktransaction.repository.TransactionRepository;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DiscountCalculator {
    private final TransactionRepository transactionRepository;

    public DiscountCalculator(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Double calculateDiscount(User user, Double amount, String transactionType) {
        if (transactionType.equals("AIRTIME")) {
            return 0.0;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfMonth = now.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime endOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        List<Transaction> transactionsThisMonth = transactionRepository.findBySourceAccountAndDateBetween(user.getAccountNumber(), startOfMonth, endOfMonth);

        Double discount = 0.0;

        if (user.getUserType() == Usertype.BUSINESS && amount > 150000 && transactionsThisMonth.size() > 3) {
            discount = 0.27 * amount;
        } else if (user.getUserType() == Usertype.RETAIL && amount > 50000 && transactionsThisMonth.size() > 3) {
            discount = 0.18 * amount;
        } else if (user.getJoinDate().isBefore(ChronoLocalDate.from(now.minusYears(4))) && transactionsThisMonth.size() <= 3) {
            discount = 0.10 * amount;
        }

        return discount;
    }
}
