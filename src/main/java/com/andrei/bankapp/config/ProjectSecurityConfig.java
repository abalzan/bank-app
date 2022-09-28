package com.andrei.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> {
                            auth.antMatchers("/account").authenticated();
                            auth.antMatchers("/balance").authenticated();
                            auth.antMatchers("/cards").authenticated();
                            auth.antMatchers("/login").permitAll();
                            auth.antMatchers("/contact").permitAll();
                            auth.antMatchers("/notices").permitAll();
                            auth.antMatchers("/").permitAll();
                    }
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
