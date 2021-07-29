package com.account.banking_transactions.repository;

import com.account.banking_transactions.dto.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findBySourceAccountIdOrderByInitiationDate(long id);
}
