package com.account.banking_transactions.service;

import com.account.banking_transactions.dto.Account;
import com.account.banking_transactions.repository.AccountRepository;
import com.account.banking_transactions.repository.TransactionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AccountService {
    AccountRepository accountRepository;
    TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account getAccount(String sortCode, String accountNumber) {
        Optional<Account> account = accountRepository
                .findBySortCodeAndAccountNumber(sortCode, accountNumber);
        account.ifPresent(value -> value.setTransactions(transactionRepository
                .findBySourceAccountIdOrderByInitiationDate(value.getId())));
        return account.orElse(null);
    }
}
