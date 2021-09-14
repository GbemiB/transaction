package com.account.banking_transactions.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Data
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

    public AccountDetails() {
    }

    public AccountDetails(long id, String sortCode, String accountNumber,
                          double currentBalance, String bankName, String ownerName) {
        this.id = id;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.ownerName = ownerName;
    }

    public AccountDetails(long id, String sortCode, String accountNumber,
                          double currentBalance, String bankName, String ownerName,
                          List<TransactionDetails> transactions) {
        this.id = id;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", sortCode='" + sortCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currentBalance=" + currentBalance +
                ", bankName='" + bankName + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
