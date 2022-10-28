package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Integer> {

    List<Cards> findByCustomerId(int customerId);
}
