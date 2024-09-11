package com.Assignment.Abc_Restaurant.Config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Assignment.Abc_Restaurant.Model.User;
import com.Assignment.Abc_Restaurant.Repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Component
@Lazy
public class CustomAuthenticationProvider implements AuthenticationProvider {

	 private final UserRepository userRepository;
	    private final PasswordEncoder passwordEncoder;

	    @Autowired
	    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Find user by username
        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new AuthenticationException("Invalid username or password") {};
        }

        User user = optionalUser.get();

        // Validate password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationException("Invalid username or password") {};
        }

        // Return the proper authority based on the user's role
        Collection<? extends GrantedAuthority> authorities;
        if (user.getRole().equals("Admin")) {
            authorities = Collections.singletonList(new SimpleGrantedAuthority("Admin"));
        } else if (user.getRole().equals("Customer")) {
            authorities = Collections.singletonList(new SimpleGrantedAuthority("Customer"));
        } else {
            throw new AuthenticationException("Invalid role") {};
        }

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
