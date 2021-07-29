package com.account.banking_transactions.util;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
@Data
public class TransactionInput {
    private AccountInput sourceAccount;
    private AccountInput targetAccount;

   @Positive(message = "Transfer amount must be positive")
    // Prevent fraudulent transfers attempting to abuse currency conversion errors
   @Min(value = 1, message = "Amount must be larger than 1")
    private double amount;

    private String reference;

    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    private Double latitude;

    @Min(value = -180, message = "Longitude must be between -180 and 180")
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    private Double longitude;

    public TransactionInput() {}
}
