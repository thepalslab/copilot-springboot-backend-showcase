package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    /**
     * Open a new account. Balance must be non-null and non-negative.
     */
    public Account openAccount(@NotNull @Valid Account account) {
        if (account.getBalance() == null) {
            throw new IllegalArgumentException("Initial balance must not be null");
        }
        if (account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance must be non-negative");
        }
        Account saved = accountRepository.save(account);
        log.info("Opened account with id={} accountNumber={}", saved.getId(), saved.getAccountNumber());
        return saved;
    }

    /**
     * Retrieve account by id or throw EntityNotFoundException.
     */
    public Account getAccountById(@NotNull Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + id));
    }

    /**
     * Replace account balance atomically. New balance must be zero or positive.
     */
    @Transactional
    public Account updateBalance(@NotNull Long accountId, @NotNull @PositiveOrZero BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("New balance must be zero or positive");
        }
        Account account = getAccountById(accountId);
        BigDecimal old = account.getBalance();
        account.setBalance(newBalance);
        Account saved = accountRepository.save(account);
        log.info("Updated balance for accountId={} oldBalance={} newBalance={}", accountId, old, newBalance);
        return saved;
    }
}
