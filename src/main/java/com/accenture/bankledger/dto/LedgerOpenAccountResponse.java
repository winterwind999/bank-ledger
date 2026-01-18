package com.accenture.bankledger.dto;

import java.time.LocalDate;

public class LedgerOpenAccountResponse {

    private String accountNumber;

    private LocalDate effectiveDate;

    private LocalDate expiryDate;

    public LedgerOpenAccountResponse(String accountNumber, LocalDate effectiveDate, LocalDate expiryDate) {
        this.accountNumber = accountNumber;
        this.effectiveDate = effectiveDate;
        this.expiryDate = expiryDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
