package com.andrei.bankapp.service;

import com.andrei.bankapp.model.Cards;
import com.andrei.bankapp.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    public List<Cards> getCustomerCardDetails(int customerId) {
        return cardsRepository.findByCustomerId(customerId);
    }
}
