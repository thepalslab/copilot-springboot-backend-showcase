package com.example.demo.repository;

import com.example.demo.model.Transaction;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t " +
            "WHERE t.sourceAccount.id = :accountId " +
            "AND t.type = com.example.demo.model.TransactionType.TRANSFER " +
            "AND DATE(t.timestamp) = :date " +
            "AND t.status = com.example.demo.model.TransactionStatus.COMPLETED")
    BigDecimal sumTransfersForAccountOnDate(Long id, LocalDate today);

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t " +
            "WHERE t.sourceAccount.id = :accountId " +
            "AND t.type = com.example.demo.model.TransactionType.TRANSFER " +
            "AND t.status = com.example.demo.model.TransactionStatus.COMPLETED")
    BigDecimal totalTransfersForAccount(@Param("accountId") Long accountId);

    @Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t " +
            "WHERE t.type = com.example.demo.model.TransactionType.TRANSFER " +
            "AND t.status = com.example.demo.model.TransactionStatus.COMPLETED " +
            "AND DATE(t.timestamp) = :date")
    BigDecimal totalTransfersOnDate(@Param("date") LocalDate date);

    List<Transaction> findBySourceAccountIdOrTargetAccountId(@NotNull Long sourceAccountId, @NotNull Long targetAccountId);
}