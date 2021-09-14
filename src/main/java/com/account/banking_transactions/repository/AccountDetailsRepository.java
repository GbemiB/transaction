package com.account.banking_transactions.repository;

import com.account.banking_transactions.dto.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AccountDetailsRepository extends JpaRepository <AccountDetails, Long> {
    Optional<AccountDetails> findBySortCodeAndAccountNumber(String sortCode, String accountNumber);
}

