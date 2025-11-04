package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.TransactionRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private final TransactionRepository transactionRepository;

    // Daily transfer limit, configurable via application.properties
    @Value("${fraud.daily-transfer-limit:10000}")
    private BigDecimal dailyTransferLimit;

    /**
     * Checks if the account's total transfers for today exceed the daily limit.
     */
    public boolean isTransferAllowed(@NotNull Account account, @NotNull BigDecimal amount) {
        LocalDate today = LocalDate.now();
        BigDecimal todayTotal = transactionRepository.sumTransfersForAccountOnDate(account.getId(), today);
        if (todayTotal == null) {
            todayTotal = BigDecimal.ZERO;
        }
        BigDecimal projectedTotal = todayTotal.add(amount);

        BigDecimal limit = dailyTransferLimit != null ? dailyTransferLimit : BigDecimal.valueOf(10000);
        boolean allowed = projectedTotal.compareTo(limit) <= 0;
        log.info("Fraud check for accountId={}: todayTotal={}, amount={}, limit={}, allowed={}",
                account.getId(), todayTotal, amount, dailyTransferLimit, allowed);
        return allowed;
    }
}