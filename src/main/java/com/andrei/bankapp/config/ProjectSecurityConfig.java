package com.andrei.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;


@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

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
                    .and().authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/account").hasRole("USER");
                            auth.requestMatchers("/balance").hasAnyRole("USER", "ADMIN");
                            auth.requestMatchers("/cards").authenticated(); //use for PostAuthorize sample
                            auth.requestMatchers("/loans").authenticated(); //use PreAuthorize sample
                            auth.requestMatchers("/user").authenticated();
                            auth.requestMatchers("/contact").permitAll();
                            auth.requestMatchers("/notices").permitAll();
                            auth.requestMatchers("/register").permitAll();
                       }
                ).oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

        return http.build();
    }
}
