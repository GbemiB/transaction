package com.account.banking_transactions.repository;

import com.account.banking_transactions.dto.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
        List<TransactionDetails> findBySourceAccountIdOrderByInitiationDate(long id);
}
