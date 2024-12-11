package com.example.pal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.pal.security.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(auth -> auth
            // Define role-based access control
            .requestMatchers("/catalogue/**", "/reservations/**").hasRole("CLIENT") // Clients can view catalogue and make reservations
            .requestMatchers("/commandes/**").hasAnyRole("CLIENT", "AGENT_COMMERCIAL") // Commande-related actions for CLIENT and AGENT_COMMERCIAL
            .requestMatchers("/users/new", "/users/delete/**", "/voitures/**").hasRole("RESPONSABLE_MARKETING") // Marketing can manage users and cars
            .requestMatchers("/test/**").hasRole("AGENT_DE_TEST") // Test-related actions for AGENT_DE_TEST
            .anyRequest().authenticated() // All other requests require authentication
        )
            .formLogin(form -> form
                .permitAll() // Allow access to login page
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // No encryption, use plain text
    }


    @Bean
    public AuthenticationManager authManager(HttpSecurity http, CustomUserDetailsService userDetailsService) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authBuilder
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());

        return authBuilder.build();
    }
}
