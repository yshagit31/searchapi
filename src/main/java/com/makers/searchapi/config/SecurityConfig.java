package com.makers.searchapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF using the new approach
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/supplier/add").hasRole("ADMIN")  // Restrict supplier addition to ADMIN role
                        .requestMatchers("/supplier/query").authenticated()  // Require authentication for querying suppliers
                        .anyRequest().permitAll()  // Allow all other requests without authentication
                )
                .httpBasic(httpBasic -> httpBasic  // Enable HTTP Basic authentication
                        .realmName("Makersharks API")  // Optional: Customize the realm name
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Configure session management to be stateless
                );

        return http.build();
    }
}
