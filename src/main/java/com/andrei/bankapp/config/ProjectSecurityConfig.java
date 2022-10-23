package com.andrei.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/account").authenticated();
                            auth.requestMatchers("/balance").authenticated();
                            auth.requestMatchers("/cards").authenticated();
                            auth.requestMatchers("/loans").authenticated();
                            auth.requestMatchers("/login").permitAll();
                            auth.requestMatchers("/contact").permitAll();
                            auth.requestMatchers("/notices").permitAll();
                            auth.requestMatchers("/register").permitAll();
                            auth.requestMatchers("/").permitAll();
                        }
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
