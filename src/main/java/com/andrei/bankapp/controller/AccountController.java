package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Accounts;
import com.andrei.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account")
    public Accounts getAccountDetails(@RequestParam int id) {
        return accountService.findByCustomerId(id);

    }
}
