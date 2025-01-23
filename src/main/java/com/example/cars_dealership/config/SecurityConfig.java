package com.example.cars_dealership.config;

import com.example.cars_dealership.enums.Role;
import com.example.cars_dealership.enums.PowerType;
import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.*;
import com.example.cars_dealership.repository.*;
import com.example.cars_dealership.service.LoginService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (only for development, enable for production)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/signup").permitAll() // Public endpoints
                        .requestMatchers("/marketing/**").hasRole("AGENT_MARKETING")
                        .requestMatchers("/commercial/**").hasRole("AGENT_COMMERCIAL")
                        .requestMatchers("/test/**").hasRole("AGENT_TEST")
                        .requestMatchers("/client/**").hasRole("CLIENT")
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .successHandler(customAuthenticationSuccessHandler()) // Custom success handler
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoginService customAuthenticationSuccessHandler() {
        return new LoginService();
    }

    @Bean
    CommandLineRunner initDatabase(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            VoitureRepository voitureRepository,
            ColorRepository colorRepository,
            MoteurRepository moteurRepository,
            FeatureRepository featureRepository,
            VariantRepository variantRepository,
            ImageRepository imageRepository,
            CommandeRepository commandeRepository,
            ReservationRepository reservationRepository) {
        return args -> {
            // Initialize Users
//            User client1 = userRepository.save(new User("Abdo", "Bokh", "0123456789", "client@example.com", Role.CLIENT, passwordEncoder.encode("password")));
//            userRepository.save(new User("Abdo", "Bokh", "0123456789", "marketing@example.com", Role.AGENT_MARKETING, passwordEncoder.encode("password")));
//            userRepository.save(new User("Abdo", "Bokh", "0123456789", "test@example.com", Role.AGENT_TEST, passwordEncoder.encode("password")));
//            userRepository.save(new User("Abdo", "Bokh", "0123456789", "commercial@example.com", Role.AGENT_COMMERCIAL, passwordEncoder.encode("password")));
//
//            Image mainImage = new Image("/images/208_0.jpg", "208_0");
//            Image variantImage1 = new Image("/images/208_1.jpg", "208_1");
//            Image variantImage2 = new Image("/images/208_2.jpg", "208_2");
//            Image variantImage3 = new Image("/images/208_3.jpg", "208_3");
//
//            Color Black = colorRepository.save(new Color("Black", "#000000"));
//            Color White = colorRepository.save(new Color("White", "#FFFFFF"));
//            Color Yellow = colorRepository.save(new Color("Yellow", "#FFFF00"));
//
//            Moteur moteur1 = moteurRepository.save(new Moteur("Essence THP", "1.6 litre", "A powerful 165 horsepower engine for the new 208."));
//
//            Feature feature1 = new Feature("Toit ouvrant", 2000);
//
//            Voiture voiture208 = new Voiture("208", "New model of 208 with modern design and advanced features.", "Peugeot", List.of(mainImage));
//            Variant variant1 = new Variant(voiture208, Black, moteur1, PowerType.ESSENCE, 10, List.of(feature1), 21000, List.of(variantImage1));
//            Variant variant2 = new Variant(voiture208, White, moteur1, PowerType.ESSENCE, 15, List.of(), 21000, List.of(variantImage2));
//            Variant variant3 = new Variant(voiture208, Yellow, moteur1, PowerType.ESSENCE, 12, List.of(), 21000, List.of(variantImage3));
//            voitureRepository.save(voiture208);
//            variantRepository.saveAll(List.of(variant1, variant2, variant3));
//
//            mainImage.setVoiture_images(voiture208);
//            variantImage1.setVariant_images(variant1);
//            variantImage2.setVariant_images(variant2);
//            variantImage3.setVariant_images(variant3);
//
//            imageRepository.saveAll(List.of(mainImage, variantImage1, variantImage2, variantImage3));
//
//            Commande commande1 = new Commande(client1, variant1, StatusCommande.EN_ATTENTE, BigDecimal.valueOf(23000), new Date());
//            Commande commande2 = new Commande(client1, variant2, StatusCommande.EN_ATTENTE, BigDecimal.valueOf(22000), new Date());
//            Commande commande3 = new Commande(client1, variant3, StatusCommande.EN_ATTENTE, BigDecimal.valueOf(24000), new Date());
//            commandeRepository.saveAll(List.of(commande1, commande2, commande3));
//
//            Reservation reservation1 = new Reservation(client1, variant1, StatusReservation.EN_ATTENTE, new Date());
//            Reservation reservation2 = new Reservation(client1, variant2, StatusReservation.EN_ATTENTE, new Date());
//            Reservation reservation3 = new Reservation(client1, variant3, StatusReservation.EN_ATTENTE, new Date());
//            reservationRepository.saveAll(List.of(reservation1, reservation2, reservation3));
        };
    };
}