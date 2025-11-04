package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * Open a new account.
     */
    @PostMapping("/open")
    public ResponseEntity<Account> openAccount(@Valid @RequestBody Account account) {
        Account created = accountService.openAccount(account);
        return ResponseEntity.status(201).body(created);
    }

    /**
     * Fetch account by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable @NotNull Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }
}
