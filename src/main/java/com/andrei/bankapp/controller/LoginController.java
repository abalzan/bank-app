package com.andrei.bankapp.controller;

import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        try {
            String hashPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashPassword);
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok("User registered successfully" + savedCustomer.getEmail());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }
}
