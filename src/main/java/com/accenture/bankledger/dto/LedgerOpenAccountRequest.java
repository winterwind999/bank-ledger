package com.accenture.bankledger.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class LedgerOpenAccountRequest {

    @NotBlank
    @Size(min = 6, max = 9)
    @Digits(integer = 9, fraction = 0)
    private String productId;

    @NotNull
    @Valid
    private TermDepositDetails termDepositDetails;

    @NotNull
    @Valid
    private TermDepositMaturityDetails termDepositMaturityDetails;

    public LedgerOpenAccountRequest() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public TermDepositDetails getTermDepositDetails() {
        return termDepositDetails;
    }

    public void setTermDepositDetails(TermDepositDetails termDepositDetails) {
        this.termDepositDetails = termDepositDetails;
    }

    public TermDepositMaturityDetails getTermDepositMaturityDetails() {
        return termDepositMaturityDetails;
    }

    public void setTermDepositMaturityDetails(TermDepositMaturityDetails termDepositMaturityDetails) {
        this.termDepositMaturityDetails = termDepositMaturityDetails;
    }

    public static class Builder {
        private String productId;
        private TermDepositDetails termDepositDetails;
        private TermDepositMaturityDetails termDepositMaturityDetails;

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder termDepositDetails(TermDepositDetails termDepositDetails) {
            this.termDepositDetails = termDepositDetails;
            return this;
        }

        public Builder termDepositMaturityDetails(TermDepositMaturityDetails termDepositMaturityDetails) {
            this.termDepositMaturityDetails = termDepositMaturityDetails;
            return this;
        }

        public LedgerOpenAccountRequest build() {
            return new LedgerOpenAccountRequest(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private LedgerOpenAccountRequest(Builder builder) {
        productId = builder.productId;
        termDepositDetails = builder.termDepositDetails;
        termDepositMaturityDetails = builder.termDepositMaturityDetails;
    }
}
