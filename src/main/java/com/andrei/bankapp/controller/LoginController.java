package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final CustomerService customerService;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        return customerService.getDetailsByEmail(authentication.getName());
    }
}
