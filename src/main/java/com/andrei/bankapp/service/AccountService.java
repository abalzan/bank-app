package com.andrei.bankapp.service;

import com.andrei.bankapp.error.UserNotFoundException;
import com.andrei.bankapp.model.Accounts;
import com.andrei.bankapp.repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountsRepository accountRepository;


    public Accounts findByCustomerId(int id) {
        return accountRepository.findByCustomerId(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }
}
