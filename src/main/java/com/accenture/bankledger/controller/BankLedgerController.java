package com.accenture.bankledger.controller;

import com.accenture.bankledger.dto.LedgerOpenAccountRequest;
import com.accenture.bankledger.dto.LedgerOpenAccountResponse;
import com.accenture.bankledger.service.BankLedgerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ms-bank-ledger")
public class BankLedgerController {

    private final Logger log = LoggerFactory.getLogger(BankLedgerController.class);
    private final BankLedgerService bankLedgerService;

    public BankLedgerController(BankLedgerService bankLedgerService) {
        this.bankLedgerService = bankLedgerService;
    }

    @PostMapping("/createAccount")
    public LedgerOpenAccountResponse createAccount(@Valid @RequestBody LedgerOpenAccountRequest ledgerOpenAccountRequest) {
        log.info("Creating a Bank Ledger Account");

        return this.bankLedgerService.createAccount(ledgerOpenAccountRequest);
    }
}
