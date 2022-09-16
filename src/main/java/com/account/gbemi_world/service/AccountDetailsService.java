package com.account.gbemi_world.service;

import com.account.gbemi_world.dto.AccountDetails;
import com.account.gbemi_world.repository.AccountDetailsRepository;
import com.account.gbemi_world.repository.TransactionDetailsRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class AccountDetailsService {
    private final AccountDetailsRepository accountRepository;
    private final TransactionDetailsRepository transactionRepository;

    public AccountDetails getAccount(String sortCode, String accountNumber) {
        Optional<AccountDetails> account = accountRepository
                .findBySortCodeAndAccountNumber(sortCode, accountNumber);
        account.ifPresent(value -> value.setTransactions(transactionRepository
                .findBySourceAccountIdOrderByInitiationDate(value.getId())));
        return account.orElse(null);
    }
}
