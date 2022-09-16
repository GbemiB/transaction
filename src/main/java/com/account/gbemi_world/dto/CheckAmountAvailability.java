package com.account.gbemi_world.dto;

import lombok.Data;

@Data
public class CheckAmountAvailability {
    private double amount;
    private double accountBalance;
}
