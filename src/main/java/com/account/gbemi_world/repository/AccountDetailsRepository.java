package com.account.gbemi_world.repository;

import com.account.gbemi_world.dto.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findBySortCodeAndAccountNumber(String sortCode, String accountNumber);
}

