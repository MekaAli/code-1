package com.example.pal.controller;

import com.example.pal.model.Utilisateur;
import com.example.pal.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Get all utilisateurs
    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    // Get utilisateur by id
    @GetMapping("/{id}")
    public Utilisateur getUtilisateurById(@PathVariable Long id) {
        return utilisateurService.getUtilisateurById(id);
    }

    // Save or update utilisateur
    @PostMapping
    public Utilisateur saveOrUpdateUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveOrUpdateUtilisateur(utilisateur);
    }

    // Update the role of a utilisateur
    @PutMapping("/{id}/role")
    public void updateUtilisateurRole(@PathVariable Long id, @RequestParam String newRole) {
        utilisateurService.updateUtilisateurRole(id, newRole);
    }

    // Delete utilisateur by id
    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
    }
}
