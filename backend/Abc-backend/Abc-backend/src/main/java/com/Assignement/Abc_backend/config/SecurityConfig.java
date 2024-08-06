package com.Assignement.Abc_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain defauFilterChain(HttpSecurity httpSecurity) throws Exception{
      httpSecurity
            .csrf().disable()
            .authorizeRequests()
                .requestMatchers("/register", "/login").permitAll() // Allow access to register and login endpoints
                .anyRequest().authenticated() // All other requests need authentication
            .and()
            .formLogin()
                .loginPage("/login") // Custom login page URL
                //.successHandler(successHandler) // Custom success handler
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            .and()
            .sessionManagement()
                .maximumSessions(1) // Allow only one session per user
                .expiredUrl("/login?expired");

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
}
