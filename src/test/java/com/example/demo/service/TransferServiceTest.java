// File: src/test/java/com/example/demo/service/TransferServiceTest.java
package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TransferServiceTest {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private TransferService transferService;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        transactionRepository = mock(TransactionRepository.class);
        transferService = new TransferService(accountRepository, transactionRepository);
    }

    @Test
    void shouldTransferFundsWhenBalanceIsSufficient() {
        Account source = Account.builder()
                .id(1L)
                .accountNumber("Alice")
                .balance(new BigDecimal("5000"))
                .customer(mock(Customer.class)) // or provide a real Customer instance
                .build();
        Account target = Account.builder()
                .id(2L)
                .accountNumber("Bob")
                .balance(new BigDecimal("2000"))
                .customer(mock(Customer.class)) // or provide a real Customer instance
                .build();

        when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(source));
        when(accountRepository.findById(2L)).thenReturn(java.util.Optional.of(target));

        transferService.transferFunds(1L, 2L, new BigDecimal(1000));

        assertEquals(new BigDecimal(4000), source.getBalance());
        assertEquals(new BigDecimal(3000), target.getBalance());
        verify(accountRepository).save(source);
        verify(accountRepository).save(target);
    }
}