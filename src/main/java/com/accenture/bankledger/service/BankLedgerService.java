package com.accenture.bankledger.service;

import com.accenture.bankledger.dto.LedgerOpenAccountRequest;
import com.accenture.bankledger.dto.LedgerOpenAccountResponse;

public interface BankLedgerService {

    LedgerOpenAccountResponse createAccount(LedgerOpenAccountRequest ledgerOpenAccountRequest);
}
