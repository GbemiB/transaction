package com.account.gbemi_world.controller;


import com.account.gbemi_world.dto.AccountDetails;
import com.account.gbemi_world.service.AccountDetailsService;
import com.account.gbemi_world.util.AccountInput;
import com.account.gbemi_world.util.InputValidator;
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
public class AccountRestController {
    private final AccountDetailsService accountService;

    @SneakyThrows
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

