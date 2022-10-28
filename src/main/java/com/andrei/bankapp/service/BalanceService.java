package com.andrei.bankapp.service;

import com.andrei.bankapp.model.AccountTransactions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final AccountTransactionsService accountTransactionsService;


    public List<AccountTransactions> getTransactionsByCustomer(int customerId) {
        return accountTransactionsService.getTransactionsByCustomer(customerId);
    }
}
