package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FraudCheckServiceTest {

    private TransactionRepository transactionRepository;
    private FraudCheckService fraudCheckService;

    @BeforeEach
    void setUp() {
        transactionRepository = mock(TransactionRepository.class);
        fraudCheckService = new FraudCheckService(transactionRepository);
        // Optionally set the daily limit if not injected via @Value
        // ReflectionTestUtils.setField(fraudCheckService, "dailyTransferLimit", new BigDecimal("10000"));
    }

    @Test
    void shouldBlockTransferWhenOverDailyLimit() {
        Account account = Account.builder()
                .id(1L)
                .accountNumber("123456")
                .balance(new BigDecimal("5000.00"))
                .customer(mock(com.example.demo.model.Customer.class))
                .build();

        // Simulate today's total is 9500, limit is 10000, transfer amount is 600
        when(transactionRepository.sumTransfersForAccountOnDate(eq(1L), any()))
                .thenReturn(new BigDecimal("9500.00"));

        boolean allowed = fraudCheckService.isTransferAllowed(account, new BigDecimal("600.00"));

        assertFalse(allowed, "Transfer should be blocked when exceeding daily limit");
    }
}