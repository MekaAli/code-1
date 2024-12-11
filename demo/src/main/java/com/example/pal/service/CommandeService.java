package com.example.pal.service;

import com.example.pal.enums.StatusCommande;
import com.example.pal.model.Commande;
import com.example.pal.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    // Récupérer toutes les commandes
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Récupérer une commande par son id
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande introuvable"));
    }

    // Ajouter ou mettre à jour une commande
    public Commande saveOrUpdateCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Mettre à jour le statut d'une commande
    public void updateCommandeStatus(Long id, String newStatus) {
        // Convert the string status to StatusCommande enum
        StatusCommande statusCommande = StatusCommande.valueOf(newStatus.toUpperCase());
        
        Commande commande = commandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        
        commande.updateStatus(statusCommande); // Now passing the enum value
        commandeRepository.save(commande);
    }
    
    // Mettre à jour le statut d'une commande
    public void updateCommandeStatus(Long id, StatusCommande newStatus) {
        
        Commande commande = commandeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Commande introuvable"));
        
        commande.updateStatus(newStatus); // Now passing the enum value
        commandeRepository.save(commande);
    }

    // Supprimer une commande
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
