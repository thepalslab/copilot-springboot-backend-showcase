package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    @NotNull
    private Long sourceId;

    @NotNull
    private Long targetId;

    @NotNull
    @Positive
    private BigDecimal amount;
}