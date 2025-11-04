package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionType;
import com.example.demo.model.TransactionStatus;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    /**
     * Transfer funds between two accounts atomically.
     * Throws exception if source has insufficient balance.
     */
    @Transactional
    public void transferFunds(
            @NotNull Long sourceAccountId,
            @NotNull Long targetAccountId,
            @NotNull @Positive BigDecimal amount
    ) {
        log.info("Starting transfer: sourceAccountId={}, targetAccountId={}, amount={}", sourceAccountId, targetAccountId, amount);

        Account source = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Source account not found: " + sourceAccountId));
        Account target = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new EntityNotFoundException("Target account not found: " + targetAccountId));

        if (source.getBalance().compareTo(amount) < 0) {
            log.error("Insufficient balance for accountId={}", sourceAccountId);
            throw new IllegalArgumentException("Insufficient balance");
        }

        source.setBalance(source.getBalance().subtract(amount));
        target.setBalance(target.getBalance().add(amount));

        accountRepository.save(source);
        accountRepository.save(target);

        Transaction transaction = Transaction.builder()
                .sourceAccount(source)
                .targetAccount(target)
                .amount(amount)
                .type(TransactionType.TRANSFER)
                .status(TransactionStatus.COMPLETED)
                .timestamp(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        log.info("Completed transfer: transactionId={}, sourceAccountId={}, targetAccountId={}, amount={}",
                transaction.getId(), sourceAccountId, targetAccountId, amount);
    }
}
