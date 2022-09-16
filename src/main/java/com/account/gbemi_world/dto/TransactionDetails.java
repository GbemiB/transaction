package com.account.gbemi_world.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
@RequiredArgsConstructor
@ToString
@Data
@Entity
@Table(name = "transaction", schema = "online_bank")
@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_sequence", schema = "online_bank", initialValue = 5)
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    private long id;
    private long sourceAccountId;
    private long targetAccountId;
    private String sourceOwnerName;
    private String sourceCountry;
    private String targetOwnerName;
    private String targetCountry;
    private String currency;
    private double amount;
    private LocalDateTime initiationDate;
    private LocalDateTime completionDate;
    private String reference;
    private String comment;
    private Double latitude;
    private Double longitude;

}
