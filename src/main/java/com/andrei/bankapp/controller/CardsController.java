package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Cards;
import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.service.CardsService;
import com.andrei.bankapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;
    private final CustomerService customerService;

    @PostAuthorize("hasRole('USER')")
    @GetMapping("/cards")
    public List<Cards> getCardsDetails(@RequestParam String email) {
        Customer customer = customerService.getDetailsByEmail(email);
        return cardsService.getCustomerCardDetails(customer.getId());
    }
}
