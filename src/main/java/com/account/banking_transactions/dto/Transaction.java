package com.account.banking_transactions.dto;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction", schema = "online_bank")
@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_sequence", schema = "online_bank", initialValue = 5)
public class Transaction {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
        private long id;
        private long sourceAccountId;
        private long targetAccountId;
        private String targetOwnerName;
        private double amount;
        private LocalDateTime initiationDate;
        private LocalDateTime completionDate;
        private String reference;
        private Double latitude;
        private Double longitude;

        public Transaction() {
        }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                ", targetOwnerName='" + targetOwnerName + '\'' +
                ", amount=" + amount +
                ", initiationDate=" + initiationDate +
                ", completionDate=" + completionDate +
                ", reference='" + reference + '\'' +
                '}';
    }
}
