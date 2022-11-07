package com.andrei.bankapp.service;

import com.andrei.bankapp.model.Loans;
import com.andrei.bankapp.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoansService {

    private final LoansRepository loansRepository;

    public List<Loans> getCustomerLoansDetails(int customerId) {
        return loansRepository.findByCustomerIdOrderByCreatedDateDesc(customerId);
    }
}
