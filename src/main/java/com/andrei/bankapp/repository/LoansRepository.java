package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoansRepository extends JpaRepository<Loans, Integer> {

    List<Loans> findByCustomerIdOrderByCreatedDateDesc(int customerId);
}
