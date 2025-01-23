package com.example.cars_dealership.controller;

import com.example.cars_dealership.enums.Role;
import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public String signupForm() {
        return "signup"; // Renders signup.html
    }

    @PostMapping
    public String signup(@RequestParam String nom,
                         @RequestParam String prenom,
                         @RequestParam String numeroTel,
                         @RequestParam String adresseEmail,
                         @RequestParam String password,
                         @RequestParam String passwordConfirmation,
                         Model model) {

        // Check if email already exists
        if (userRepository.findByAdresseEmail(adresseEmail).isPresent()) {
            model.addAttribute("emailError", "Cet email est déjà utilisé.");
            return "signup";
        }

        // Check if passwords match
        if (!password.equals(passwordConfirmation)) {
            model.addAttribute("passwordError", "Les mots de passe ne correspondent pas.");
            return "signup";
        }

        // Check if password is at least 8 characters
        if (password.length() < 8) {
            model.addAttribute("passwordLengthError", "Le mot de passe doit contenir au moins 8 caractères.");
            return "signup";
        }

        // Create and save new user
        User newUser = new User(nom, prenom, numeroTel, adresseEmail, Role.CLIENT, passwordEncoder.encode(password));
        userRepository.save(newUser);
        return "redirect:/login?success";
    }
}

