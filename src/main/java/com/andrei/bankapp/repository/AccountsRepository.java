package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Integer> {
    Optional<Accounts> findByCustomerId(Integer customerId);
}
