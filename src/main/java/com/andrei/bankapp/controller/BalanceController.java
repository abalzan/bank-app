package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.AccountTransactions;
import com.andrei.bankapp.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/balance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        return balanceService.getTransactionsByCustomer(id);
    }
}
