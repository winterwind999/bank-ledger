package com.accenture.bankledger.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(nullable = false, updatable = false)
    private String accountNumber;

    private String productId;

    private BigDecimal interestRate;

    private BigDecimal depositAmount;

    private int termMonths;

    private LocalDate effectiveDate;

    private LocalDate expiryDate;

    private String accountName;

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public static class Builder {
        private String accountNumber;

        private String productId;

        private BigDecimal interestRate;

        private BigDecimal depositAmount;

        private int termMonths;

        private LocalDate effectiveDate;

        private LocalDate expiryDate;

        private String accountName;

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder interestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder depositAmount(BigDecimal depositAmount) {
            this.depositAmount = depositAmount;
            return this;
        }

        public Builder termMonths(int termMonths) {
            this.termMonths = termMonths;
            return this;
        }

        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder expiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private Account(Builder builder) {
        accountNumber = builder.accountNumber;
        productId = builder.productId;
        interestRate = builder.interestRate;
        depositAmount = builder.depositAmount;
        termMonths = builder.termMonths;
        effectiveDate = builder.effectiveDate;
        expiryDate = builder.expiryDate;
        accountName = builder.accountName;
    }
}
