package com.account.banking_transactions.service;

import com.account.banking_transactions.dto.AccountDetails;
import com.account.banking_transactions.dto.TransactionDetails;
import com.account.banking_transactions.repository.AccountDetailsRepository;
import com.account.banking_transactions.repository.TransactionDetailsRepository;
import com.account.banking_transactions.util.TransactionInput;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Service
public class TransactionDetailsService {
    AccountDetailsRepository accountRepository;
    TransactionDetailsRepository transactionRepository;

    public TransactionDetailsService(AccountDetailsRepository accountRepository, TransactionDetailsRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }
    public boolean makeTransfer(TransactionInput transactionInput) {
        String sourceSortCode = transactionInput.getSourceAccount().getSortCode();
        String sourceAccountNumber = transactionInput.getSourceAccount().getAccountNumber();
        Optional<AccountDetails> sourceAccount = accountRepository
                .findBySortCodeAndAccountNumber(sourceSortCode, sourceAccountNumber);

        String targetSortCode = transactionInput.getTargetAccount().getSortCode();
        String targetAccountNumber = transactionInput.getTargetAccount().getAccountNumber();
        Optional<AccountDetails> targetAccount = accountRepository
                .findBySortCodeAndAccountNumber(targetSortCode, targetAccountNumber);

        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
            if (isAmountAvailable(transactionInput.getAmount(), sourceAccount.get().getCurrentBalance())) {
                var transaction = new TransactionDetails();
                transaction.setAmount(transactionInput.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                transaction.setTargetOwnerName(targetAccount.get().getOwnerName());
                transaction.setInitiationDate(LocalDateTime.now());
                transaction.setCompletionDate(LocalDateTime.now());
                transaction.setReference(transactionInput.getReference());
                transaction.setLatitude(transactionInput.getLatitude());
                transaction.setLongitude(transactionInput.getLongitude());
                updateAccountBalance(sourceAccount.get(), transactionInput.getAmount());
                transactionRepository.save(transaction);
                return true;
            }
        }
        return false;
    }

    private void updateAccountBalance(AccountDetails account, double amount) {
        account.setCurrentBalance((account.getCurrentBalance() - amount));
        accountRepository.save(account);
    }

    private boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }
}


