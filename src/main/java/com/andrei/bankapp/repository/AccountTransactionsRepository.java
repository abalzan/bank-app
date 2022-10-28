package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransactions, String> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDateDesc(int customerId);
}
