package com.account.banking_transactions.dto;

import lombok.Data;

@Data
public class CheckAmountAvailability {
    private double amount;
    private double accountBalance;
}
