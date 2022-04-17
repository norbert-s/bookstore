package com.norbert.susztek.bookstore.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public class SecurityConfig {
    protected void configure(HttpSecurity http) throws Exception {
        http

		.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
        );
    }
}
