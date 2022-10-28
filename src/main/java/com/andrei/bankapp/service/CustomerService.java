package com.andrei.bankapp.service;

import com.andrei.bankapp.error.UserNotFoundException;
import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getDetailsByEmail(String email) {
        List<Customer> customers = customerRepository.findByEmail(email);
        return customers.stream().findFirst().orElseThrow(() -> new UserNotFoundException("Email not found " + email));
    }
}
