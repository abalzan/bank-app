package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loans, Integer> {

    @PreAuthorize("hasRole('USER')")
    List<Loans> findByCustomerIdOrderByStartDateDesc(int customerId);
}
