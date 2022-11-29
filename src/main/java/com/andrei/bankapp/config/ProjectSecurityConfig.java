package com.andrei.bankapp.config;

import com.andrei.bankapp.filter.AuthoritiesLoggingAfterFilter;
import com.andrei.bankapp.filter.JWTTokenGeneratorFilter;
import com.andrei.bankapp.filter.JWTValidatorFilter;
import com.andrei.bankapp.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
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
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors().configurationSource(request -> {
                    CorsConfiguration corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                    corsConfiguration.setExposedHeaders(Collections.singletonList("Authorization"));
                    corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                    corsConfiguration.setAllowCredentials(true);
                    corsConfiguration.setMaxAge(3600L);
                    return corsConfiguration;
                }).and().csrf().ignoringRequestMatchers( "/register").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/account").hasRole("USER");
                            auth.requestMatchers("/balance").hasAnyRole("USER", "ADMIN");
                            auth.requestMatchers("/cards").authenticated(); //use for PostAuthorize sample
                            auth.requestMatchers("/loans").authenticated(); //use PreAuthorize sample
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
