package com.accenture.bankledger.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TermDepositMaturityDetails {

    @NotBlank
    private String accountName;

    @NotBlank
    @Pattern(
            regexp = "^[0-9]{6,9}$",
            message = "Must contain only numbers and be 6 to 9 digits long"
    )
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
