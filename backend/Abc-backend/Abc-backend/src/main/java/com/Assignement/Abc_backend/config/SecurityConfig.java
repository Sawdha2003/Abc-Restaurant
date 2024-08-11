package com.Assignement.Abc_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity httpSecurity) throws Exception{
     
        httpSecurity
                  .csrf().disable()
                  .authorizeRequests()
                      .requestMatchers("/products").permitAll() // Allow access to register and login endpoints
                      .anyRequest().authenticated() // All other requests need authentication
                  .and()
                //   .formLogin()
                //       .loginPage("/SignIn") // Custom login page URL
                //       .permitAll()
                //   .and()
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
      

    
    
