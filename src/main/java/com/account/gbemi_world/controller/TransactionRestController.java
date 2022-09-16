package com.account.gbemi_world.controller;

import com.account.gbemi_world.dto.CheckAmountAvailability;
import com.account.gbemi_world.service.TransactionDetailsService;
import com.account.gbemi_world.util.InputValidator;
import com.account.gbemi_world.util.TransactionInput;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class TransactionRestController {
    private final TransactionDetailsService transactionService;

    @SneakyThrows
    @PostMapping(value = "/transactions")
    public ResponseEntity<?> makeTransfer(@Valid @RequestBody TransactionInput transactionInput) {
        if (InputValidator.isSearchTransactionValid(transactionInput)) {
            boolean isComplete = transactionService.makeTransfer(transactionInput);
            return new ResponseEntity<>(isComplete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @SneakyThrows
    @PostMapping(value = "/checkavailability")
    public ResponseEntity<?> checkAmountAvailability(@Valid @RequestBody CheckAmountAvailability availability) {
        if (availability.getAmount() != 0 && availability.getAccountBalance() != 0
                && availability.getAccountBalance() > availability.getAmount()) {
            boolean isAmountAvailable = transactionService.isAmountAvailable(availability.getAmount(),
                    availability.getAccountBalance());
            return new ResponseEntity<>(isAmountAvailable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

