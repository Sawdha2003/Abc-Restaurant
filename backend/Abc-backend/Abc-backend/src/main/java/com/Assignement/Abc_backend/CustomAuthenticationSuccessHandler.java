package com.Assignement.Abc_backend;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        // Get the roles of the logged-in user
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Redirect based on the role
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("Admin")) {
                response.sendRedirect("AdminDashboard.html"); // Redirect to Admin Dashboard
                return;
            } else if (grantedAuthority.getAuthority().equals("Customer")) {
                response.sendRedirect("Dashboard.html"); // Redirect to Customer Page
                return;
            }
            
        }

        // If no role matches, redirect to a default page
        response.sendRedirect("/");
    }
}
