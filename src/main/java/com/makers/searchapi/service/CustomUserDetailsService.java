package com.makers.searchapi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new User("user", "{noop}password", Collections.singletonList(() -> "ROLE_USER"));
        } else if ("admin".equals(username)) {
            return new User("admin", "{noop}admin", Collections.singletonList(() -> "ROLE_ADMIN"));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}
