package com.account.gbemi_world.service;

import com.account.gbemi_world.dto.AccountDetails;
import com.account.gbemi_world.dto.TransactionDetails;
import com.account.gbemi_world.repository.AccountDetailsRepository;
import com.account.gbemi_world.repository.TransactionDetailsRepository;
import com.account.gbemi_world.util.TransactionInput;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class TransactionDetailsService {
    private final AccountDetailsRepository accountRepository;
    private final TransactionDetailsRepository transactionRepository;

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

    public void updateAccountBalance(AccountDetails account, double amount) {
        account.setCurrentBalance((account.getCurrentBalance() - amount));
        accountRepository.save(account);
    }

    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }
}


