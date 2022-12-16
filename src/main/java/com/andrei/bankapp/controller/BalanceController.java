package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.AccountTransactions;
import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.service.AccountTransactionsService;
import com.andrei.bankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final CustomerService customerService;
    private final AccountTransactionsService accountTransactionsService;

    @GetMapping("/balance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
        Customer customer = customerService.getDetailsByEmail(email);
        return accountTransactionsService.getTransactionsByCustomer(customer.getId());
    }
}
