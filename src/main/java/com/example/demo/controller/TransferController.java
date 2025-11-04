package com.example.demo.controller;

import com.example.demo.dto.TransferRequest;
import com.example.demo.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    /**
     * Transfer funds between two accounts.
     */
    @PostMapping("/transfers")
    public ResponseEntity<Void> transfer(@Valid @RequestBody TransferRequest request) {
        transferService.transferFunds(
                request.getSourceId(),
                request.getTargetId(),
                request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
}