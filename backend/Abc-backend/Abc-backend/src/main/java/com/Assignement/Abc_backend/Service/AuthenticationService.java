package com.Assignment.Abc_Restaurant.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Assignment.Abc_Restaurant.Model.User;
import com.Assignment.Abc_Restaurant.Repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    private UserRepository userrepo;

     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userrepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        builder.roles(user.getRole()); 

        return builder.build();


}
}