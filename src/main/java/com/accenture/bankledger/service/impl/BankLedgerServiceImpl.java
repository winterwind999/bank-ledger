package com.accenture.bankledger.service.impl;

import com.accenture.bankledger.dto.LedgerOpenAccountRequest;
import com.accenture.bankledger.dto.LedgerOpenAccountResponse;
import com.accenture.bankledger.model.entity.Account;
import com.accenture.bankledger.repository.BankLedgerRepository;
import com.accenture.bankledger.service.BankLedgerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class BankLedgerServiceImpl implements BankLedgerService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final BankLedgerRepository bankLedgerRepository;

    public BankLedgerServiceImpl(BankLedgerRepository bankLedgerRepository) {
        this.bankLedgerRepository = bankLedgerRepository;
    }

    @Override
    public LedgerOpenAccountResponse createAccount(LedgerOpenAccountRequest ledgerOpenAccountRequest) {
        Account account = generateAccount(ledgerOpenAccountRequest);

        bankLedgerRepository.save(account);

        return new LedgerOpenAccountResponse(account.getAccountNumber(), account.getEffectiveDate(), account.getExpiryDate());
    }

    private Account generateAccount(LedgerOpenAccountRequest ledgerOpenAccountRequest) {
        LocalDate effectiveDate = convertToLocalDate(ledgerOpenAccountRequest.getTermDepositDetails().getEffectiveDate());
        LocalDate expiryDate = convertToLocalDate(ledgerOpenAccountRequest.getTermDepositDetails().getExpiryDate());

        return Account
                .builder()
                .accountNumber(ledgerOpenAccountRequest.getTermDepositMaturityDetails().getAccountNumber())
                .productId(ledgerOpenAccountRequest.getProductId())
                .interestRate(ledgerOpenAccountRequest.getTermDepositDetails().getInterestRate())
                .depositAmount(ledgerOpenAccountRequest.getTermDepositDetails().getDepositAmount())
                .termMonths(ledgerOpenAccountRequest.getTermDepositDetails().getTermMonths())
                .effectiveDate(effectiveDate)
                .expiryDate(expiryDate)
                .accountName(ledgerOpenAccountRequest.getTermDepositMaturityDetails().getAccountName())
                .build();
    }

    private LocalDate convertToLocalDate(String date) throws DateTimeParseException {
        return LocalDate.parse(date, DATE_FORMATTER);
    }
}
