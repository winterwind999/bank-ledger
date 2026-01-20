package com.accenture.bankledger.dto;

import com.accenture.bankledger.dto.validator.ValidDate;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TermDepositDetails {

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal interestRate;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    @DecimalMin(value = "0.01")
    private BigDecimal depositAmount;

    @Min(1)
    private int termMonths;

    @NotBlank
    @ValidDate
    private String effectiveDate;

    @NotBlank
    @ValidDate
    private String expiryDate;

    public TermDepositDetails() {
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

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static class Builder {
        private BigDecimal interestRate;
        private BigDecimal depositAmount;
        private int termMonths;
        private String effectiveDate;
        private String expiryDate;

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

        public Builder effectiveDate(String effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder expiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public TermDepositDetails build() {
            return new TermDepositDetails(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private TermDepositDetails(Builder builder) {
        interestRate = builder.interestRate;
        depositAmount = builder.depositAmount;
        termMonths = builder.termMonths;
        effectiveDate = builder.effectiveDate;
        expiryDate = builder.expiryDate;
    }
}
