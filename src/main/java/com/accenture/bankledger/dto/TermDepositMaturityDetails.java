package com.accenture.bankledger.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TermDepositMaturityDetails {

    @NotBlank
    private String accountName;

    @NotBlank
    @Size(min = 6, max = 9)
    @Digits(integer = 9, fraction = 0)
    private String accountNumber;

    public TermDepositMaturityDetails() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static class Builder {
        private String accountName;
        private String accountNumber;

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public TermDepositMaturityDetails build() {
            return new TermDepositMaturityDetails(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private TermDepositMaturityDetails(Builder builder) {
        accountName = builder.accountName;
        accountNumber = builder.accountNumber;
    }
}
