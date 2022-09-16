package com.account.gbemi_world.util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern sortCodePattern = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{2}$");
    private static final Pattern accountNumberPattern = Pattern.compile("^[0-9]{8}$");

    public static boolean isSearchCriteriaValid(AccountInput accountInput) {
        return sortCodePattern.matcher(accountInput.getSortCode()).find() &&
                accountNumberPattern.matcher(accountInput.getAccountNumber()).find();
    }

    public static boolean isSearchTransactionValid(TransactionInput transactionInput) {
        if (!isSearchCriteriaValid(transactionInput.getSourceAccount()))
            return false;
        if (!isSearchCriteriaValid(transactionInput.getTargetAccount()))
            return false;
        return !transactionInput.getSourceAccount().equals(transactionInput.getTargetAccount());
    }
}
