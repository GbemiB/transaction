package com.account.gbemi_world.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "account", schema = "online_bank")
public class AccountDetails {
    @Id
    private long id;
    private String sortCode;
    private String accountNumber;
    private double currentBalance;
    private String bankName;
    private String ownerName;
    private transient List<TransactionDetails> transactions;
}
