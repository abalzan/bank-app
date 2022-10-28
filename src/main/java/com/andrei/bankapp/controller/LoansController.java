package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Loans;
import com.andrei.bankapp.service.LoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoansService loansService;

    @GetMapping("/loans")
    public List<Loans> getLoansDetails(@RequestParam int id) {
        return loansService.getCustomerLoansDetails(id);

    }
}
