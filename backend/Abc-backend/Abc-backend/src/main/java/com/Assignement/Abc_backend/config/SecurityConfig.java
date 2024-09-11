package com.Assignment.Abc_Restaurant.Config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.Assignment.Abc_Restaurant.Repository.UserRepository;

@Configuration
public class SecurityConfig {

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    // CORS Configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // Security filter chain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/css/**", "/images/**", "/js/**", "/register", "/login", "/all-users", "/welcome","/Contact.html").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/login")
                .failureUrl("/login?error=true")  // Redirect to /login with error on failure
                .successHandler(customAuthenticationSuccessHandler1()) // Role-based redirect
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .authenticationProvider(customAuthenticationProvider()); // Register the custom provider directly

        return http.build();
    }

    // Custom AuthenticationSuccessHandler
    @Bean
    public AuthenticationSuccessHandler customAuthenticationSuccessHandler1() {
        return (request, response, authentication) -> {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String redirectUrl = "";

            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals("Admin")) {
                    redirectUrl = "/AdminDashboard";
                    break;
                } else if (authority.getAuthority().equals("Customer")) {
                    redirectUrl = "/dashboard";
                    break;
                }
            }

            if (redirectUrl.isEmpty()) {
                throw new IllegalStateException("No valid role found");
            }

            response.sendRedirect(redirectUrl);
        };
    }

    // Register the CustomAuthenticationProvider
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(userRepository, passwordEncoder);
    }

    // Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
