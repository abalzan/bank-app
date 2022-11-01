package com.andrei.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.securityContext().requireExplicitSave(false)
                .and().cors().configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                }).and().csrf().ignoringRequestMatchers( "/register").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/account").authenticated();
                            auth.requestMatchers("/balance").authenticated();
                            auth.requestMatchers("/cards").authenticated();
                            auth.requestMatchers("/loans").authenticated();
                            auth.requestMatchers("/user").authenticated();
                            auth.requestMatchers("/contact").permitAll();
                            auth.requestMatchers("/notices").permitAll();
                            auth.requestMatchers("/register").permitAll();
                       }
                )
                .formLogin()
                .and().httpBasic();

        return http.build();
    }
}
