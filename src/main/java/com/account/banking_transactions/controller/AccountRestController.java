package com.account.banking_transactions.controller;


import com.account.banking_transactions.dto.AccountDetails;
import com.account.banking_transactions.service.AccountDetailsService;

import com.account.banking_transactions.util.AccountInput;
import com.account.banking_transactions.util.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

    @RestController
    @RequestMapping("api/v1")
    public class AccountRestController {

        private static final Logger LOGGER = LoggerFactory.getLogger(AccountRestController.class);

        private final AccountDetailsService accountService;

        public AccountRestController(AccountDetailsService accountService) {
            this.accountService = accountService;
        }

        @PostMapping(value = "/accounts")
        public ResponseEntity<?> checkAccountBalance(@Valid @RequestBody AccountInput accountInput) {

            if (InputValidator.isSearchCriteriaValid(accountInput)) {
                AccountDetails account = accountService.getAccount(
                        accountInput.getSortCode(), accountInput.getAccountNumber());
                if (account == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                } else {
                    return new ResponseEntity<>(account, HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    // TODO PLEASE NOTE AS H2 DB

