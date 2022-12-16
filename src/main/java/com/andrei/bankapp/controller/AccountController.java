package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Accounts;
import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.service.AccountService;
import com.andrei.bankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;

    @GetMapping("/account")
    public Accounts getAccountDetails(@RequestParam String email) {
        Customer customer = customerService.getDetailsByEmail(email);
        return accountService.findByCustomerId(customer.getId());
    }
}
