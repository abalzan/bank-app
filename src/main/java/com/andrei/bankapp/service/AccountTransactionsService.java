package com.andrei.bankapp.service;

import com.andrei.bankapp.model.AccountTransactions;
import com.andrei.bankapp.repository.AccountTransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTransactionsService {
    private final AccountTransactionsRepository accountTransactionsRepository;

    public List<AccountTransactions> getTransactionsByCustomer(int customerId) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDateDesc(customerId);
    }
}
