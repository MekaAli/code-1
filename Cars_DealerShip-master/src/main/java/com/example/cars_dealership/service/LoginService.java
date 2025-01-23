package com.example.cars_dealership.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginService implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        switch (role) {
            case "ROLE_AGENT_MARKETING" -> response.sendRedirect("/stock");
            case "ROLE_AGENT_COMMERCIAL" -> response.sendRedirect("/commandes");
            case "ROLE_AGENT_TEST" -> response.sendRedirect("/reservations");
            case "ROLE_CLIENT" -> response.sendRedirect("/catalog");
            default -> response.sendRedirect("/default");
        }
    }
}

