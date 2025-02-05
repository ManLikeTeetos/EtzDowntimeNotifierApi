package com.example.ednbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/signin", 
                "/auth/register", 
                "/api/banks", 
                "/api/status", 
                "/api/reasons",
                "/api/bank-status").permitAll() // ✅ Allow login without authentication
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
