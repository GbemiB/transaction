package com.account.gbemi_world.repository;

import com.account.gbemi_world.dto.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {
    List<TransactionDetails> findBySourceAccountIdOrderByInitiationDate(long id);
}
