package com.example.pal.service;

import com.example.pal.enums.Role;
import com.example.pal.model.Utilisateur;
import com.example.pal.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get all utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Get utilisateur by id
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found"));
    }

    // Save or update utilisateur
    public Utilisateur saveOrUpdateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public void updateUtilisateurRole(Long id, Role newRole) {
        Utilisateur utilisateur = getUtilisateurById(id);
        utilisateur.setRole(newRole);
        utilisateurRepository.save(utilisateur);
    }
    
    public void updateUtilisateurRole(Long id, String newRole) {
        Role role = Role.valueOf(newRole.toUpperCase());
        Utilisateur utilisateur = getUtilisateurById(id);
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);
    }
    // Delete utilisateur by id
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
    // Register new utilisateur with default role CLIENT
    public Utilisateur registerNewUtilisateur(String email, String password) {
        if (utilisateurRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email already in use!");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(passwordEncoder.encode(password));
        utilisateur.setRole(Role.CLIENT); // Default role is CLIENT

        return utilisateurRepository.save(utilisateur);
    }
}
