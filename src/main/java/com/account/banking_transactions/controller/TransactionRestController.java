package com.account.banking_transactions.controller;

import com.account.banking_transactions.dto.CheckAmountAvailability;
import com.account.banking_transactions.service.TransactionDetailsService;
import com.account.banking_transactions.util.InputValidator;
import com.account.banking_transactions.util.TransactionInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

    @RestController
    @RequestMapping("api/v1")
    public class TransactionRestController {

        private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRestController.class);

        private final TransactionDetailsService transactionService;

        public TransactionRestController(TransactionDetailsService transactionService) {
            this.transactionService = transactionService;
        }

        @PostMapping(value = "/transactions")
        public ResponseEntity<?> makeTransfer(@Valid @RequestBody TransactionInput transactionInput) {
            if (InputValidator.isSearchTransactionValid(transactionInput)) {
                boolean isComplete = transactionService.makeTransfer(transactionInput);
                return new ResponseEntity<>(isComplete, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

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

