package com.example.demo.service;

import com.example.demo.repository.TransactionRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportService {

    private final TransactionRepository transactionRepository;

    /**
     * Summarize total transfers for a given account.
     */
    public BigDecimal getTotalTransfersForAccount(@NotNull Long accountId) {
        BigDecimal total = transactionRepository.totalTransfersForAccount(accountId);
        log.info("Total transfers for accountId={}: {}", accountId, total);
        return total;
    }

    /**
     * Summarize total transfers for a given day.
     */
    public BigDecimal getTotalTransfersOnDate(@NotNull LocalDate date) {
        BigDecimal total = transactionRepository.totalTransfersOnDate(date);
        log.info("Total transfers on date={}: {}", date, total);
        return total;
    }
}