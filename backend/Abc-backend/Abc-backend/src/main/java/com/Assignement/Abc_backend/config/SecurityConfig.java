package com.Assignement.Abc_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Assignement.Abc_backend.Repository.UserRepository;
import com.Assignement.Abc_backend.Service.AuthenticationService;


@Configuration

public class SecurityConfig {

    @Autowired
private UserRepository userrepo;

@Autowired
private AuthenticationService authservice;

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception{
     
      httpSecurity
      .csrf(AbstractHttpConfigurer::disable) 
      .authorizeHttpRequests(registry -> {
          registry.requestMatchers("/register", "/login").permitAll(); 
          registry.anyRequest().authenticated();
      })
      .formLogin(form -> form
          .loginPage("/login")
        // Redirect to a home page after successful login
          .failureUrl("/login?error=true")  // Redirect to login page with an error on failure
          .permitAll())
      .logout(logout -> logout
          .logoutUrl("/logout")
          .logoutSuccessUrl("/login?logout=true")
          .invalidateHttpSession(true)
          .deleteCookies("JSESSIONID")
          .permitAll());
              return httpSecurity.build();
            }
      
          @Bean
          public PasswordEncoder passwordEncoder() {
              return new BCryptPasswordEncoder();
          }
      }
      
