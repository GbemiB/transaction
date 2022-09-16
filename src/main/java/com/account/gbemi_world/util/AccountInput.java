package com.account.gbemi_world.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@ToString
@Data
public class AccountInput {
    @NotBlank(message = "Sort code is mandatory")
    private String sortCode;

    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AccountInput that = (AccountInput) o;
//        return Objects.equals(sortCode, that.sortCode) &&
//                Objects.equals(accountNumber, that.accountNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(sortCode, accountNumber);
//    }
}
