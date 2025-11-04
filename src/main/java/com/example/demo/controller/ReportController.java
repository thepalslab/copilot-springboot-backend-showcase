package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.service.ReportService;
import com.example.demo.repository.TransactionRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final TransactionRepository transactionRepository;

    /**
     * Get total transfers for a given day.
     */
    @GetMapping("/daily-summary")
    public ResponseEntity<BigDecimal> getDailySummary(
            @RequestParam("date") @NotNull @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        BigDecimal total = reportService.getTotalTransfersOnDate(date);
        return ResponseEntity.ok(total);
    }

    /**
     * Get all transactions for a given account.
     */
    @GetMapping("/account/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionsByAccount(
            @PathVariable @NotNull Long accountId) {
        List<Transaction> transactions = transactionRepository.findBySourceAccountIdOrTargetAccountId(accountId, accountId);
        return ResponseEntity.ok(transactions);
    }
}