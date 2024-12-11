package com.example.pal.repository;

import com.example.pal.model.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Méthode personnalisée pour rechercher par email
    Optional<Utilisateur> findByEmail(String email);
}
