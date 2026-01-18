package com.accenture.bankledger.service.impl;

import com.accenture.bankledger.dto.LedgerOpenAccountRequest;
import com.accenture.bankledger.dto.LedgerOpenAccountResponse;
import com.accenture.bankledger.dto.TermDepositDetails;
import com.accenture.bankledger.dto.TermDepositMaturityDetails;
import com.accenture.bankledger.model.entity.Account;
import com.accenture.bankledger.repository.BankLedgerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@ExtendWith(MockitoExtension.class)
public class BankLedgerServiceImplTest {

    @Mock
    private BankLedgerRepository bankLedgerRepository;

    private BankLedgerServiceImpl bankLedgerService;

    @BeforeEach
    void setUp() {
        bankLedgerService = new BankLedgerServiceImpl(bankLedgerRepository);
    }

    @DisplayName("Save an account with all the correct details")
    @Test
    void testCreateAccount() {

        TermDepositDetails mockTermDepositDetails = TermDepositDetails
                .builder()
                .interestRate(new BigDecimal("0.2"))
                .depositAmount(new BigDecimal("0.2"))
                .termMonths(12)
                .effectiveDate("21/02/2023")
                .expiryDate("21/02/2024")
                .build();
        TermDepositMaturityDetails mockTermDepositMaturityDetails = TermDepositMaturityDetails
                .builder()
                .accountName("John Sina")
                .accountNumber("123456789")
                .build();
        LedgerOpenAccountRequest mockLedgerOpenAccountRequest = LedgerOpenAccountRequest
                .builder()
                .productId("123456")
                .termDepositDetails(mockTermDepositDetails)
                .termDepositMaturityDetails(mockTermDepositMaturityDetails)
                .build();

        Mockito.when(bankLedgerRepository.save(Mockito.any(Account.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        LedgerOpenAccountResponse response = bankLedgerService.createAccount(mockLedgerOpenAccountRequest);

        Assertions.assertEquals("123456789", response.getAccountNumber());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Assertions.assertEquals(LocalDate.parse("21/02/2023", formatter), response.getEffectiveDate());
        Assertions.assertEquals(LocalDate.parse("21/02/2024", formatter), response.getExpiryDate());
    }
}
