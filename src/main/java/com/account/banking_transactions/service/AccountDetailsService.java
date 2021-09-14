package com.account.banking_transactions.service;

import com.account.banking_transactions.dto.AccountDetails;
import com.account.banking_transactions.repository.AccountDetailsRepository;
import com.account.banking_transactions.repository.TransactionDetailsRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AccountDetailsService {
    AccountDetailsRepository accountRepository;
    TransactionDetailsRepository transactionRepository;

    public AccountDetailsService(AccountDetailsRepository accountRepository,
                                 TransactionDetailsRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public AccountDetails getAccount(String sortCode, String accountNumber) {
        Optional<AccountDetails> account = accountRepository
                .findBySortCodeAndAccountNumber(sortCode, accountNumber);
        account.ifPresent(value -> value.setTransactions(transactionRepository
                .findBySourceAccountIdOrderByInitiationDate(value.getId())));
        return account.orElse(null);
    }
}
