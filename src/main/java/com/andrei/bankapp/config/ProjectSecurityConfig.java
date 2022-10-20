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
                .authorizeRequests(auth -> {
                            auth.antMatchers("/account").authenticated();
                            auth.antMatchers("/balance").authenticated();
                            auth.antMatchers("/cards").authenticated();
                            auth.antMatchers("/loans").authenticated();
                            auth.antMatchers("/login").permitAll();
                            auth.antMatchers("/contact").permitAll();
                            auth.antMatchers("/notices").permitAll();
                            auth.antMatchers("/register").permitAll();
                            auth.antMatchers("/").permitAll();
                        }
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
