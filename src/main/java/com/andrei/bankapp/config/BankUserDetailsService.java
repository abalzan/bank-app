package com.andrei.bankapp.config;

import com.andrei.bankapp.model.Customer;
import com.andrei.bankapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BankUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName;
        String password;
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Customer> customer = customerRepository.findByEmail(username);
        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User not found");
        } else {
            userName = customer.get(0).getEmail();
            password = customer.get(0).getPassword();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(userName, password, authorities);
    }
}
