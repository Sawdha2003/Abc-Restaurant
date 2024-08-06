package com.Assignement.Abc_backend.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Assignement.Abc_backend.Model.User;
import com.Assignement.Abc_backend.Repository.UserRepository;


public class AuthenticationService implements UserDetailsService{

    private UserRepository userrepo;

     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole()); // Assumes role is stored as a string

        return builder.build();


}
}