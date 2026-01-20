package com.accenture.bankledger.controller;

import com.accenture.bankledger.dto.LedgerOpenAccountResponse;
import com.accenture.bankledger.service.BankLedgerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebMvcTest(BankLedgerController.class)
class BankLedgerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BankLedgerService bankLedgerService;

    @DisplayName("Valid Product ID is pass through createAccount")
    @Test
    void testCreateAccountValid() throws Exception {

        String validRequestJson = """
        {
          "productId": "123456",
          "termDepositDetails": {
            "interestRate": 0.2,
            "depositAmount": 1000.00,
            "termMonths": 12,
            "effectiveDate": "21/02/2023",
            "expiryDate": "21/02/2024"
          },
          "termDepositMaturityDetails": {
            "accountName": "John Sina",
            "accountNumber": "123456789"
          }
        }
        """;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LedgerOpenAccountResponse mockLedgerOpenAccountResponse = new LedgerOpenAccountResponse(
                "123456789",
                LocalDate.parse("21/02/2023", formatter),
                LocalDate.parse("21/02/2024", formatter));

        Mockito.when(bankLedgerService.createAccount(Mockito.any()))
                .thenReturn(mockLedgerOpenAccountResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/ms-bank-ledger/createAccount")
                .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(validRequestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(bankLedgerService, Mockito.times(1))
                .createAccount(Mockito.any());
    }

    @DisplayName("Invalid Product ID in pass through createAccount")
    @Test
    void testCreateAccountInvalid() throws Exception {

        String invalidRequestJson = """
        {
          "productId": "123",
          "termDepositDetails": {
            "interestRate": 0.2,
            "depositAmount": 1000.00,
            "termMonths": 12,
            "effectiveDate": "21/02/2023",
            "expiryDate": "21/02/2024"
          },
          "termDepositMaturityDetails": {
            "accountName": "John Sina",
            "accountNumber": "123456789"
          }
        }
        """;

        mockMvc.perform(MockMvcRequestBuilders.post("/ms-bank-ledger/createAccount")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(invalidRequestJson))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verifyNoInteractions(bankLedgerService);
    }
}
