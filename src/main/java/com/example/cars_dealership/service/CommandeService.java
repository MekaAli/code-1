package com.example.cars_dealership.service;

import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.model.Commande;
import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.CommandeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    // Get all commandes
    public Page<Commande> getAllCommandes(Pageable pageable) {
        return commandeRepository.findAllByOrderByDateDesc(pageable);
    }

    //Validate Commande
    public void validateCommande(Commande commande) {
        commande.validate(); // Call the entity method
        commandeRepository.save(commande); // Persist the change using the instance
    }

    //Annulee Commande
    public void cancelCommande(Commande commande) {
        commande.cancel(); // Call the entity method
        commandeRepository.save(commande); // Persist the change using the instance
    }

    //Get all commandes for a Client
    public List<Commande> getCommandesByClient(User client) {
        return commandeRepository.findAllByClient(client);
    }

    public void updateCommandeStatus(Long idCommande, StatusCommande statusCommande) {
        Commande commande = commandeRepository.findById(idCommande)
                .orElseThrow(() -> new IllegalArgumentException("Commande not found."));
        commande.setStatusCommande(statusCommande);
        commandeRepository.save(commande);
    }

    public List<Commande> searchCommandes(String clientId, String variantId, String commandeId, String price, String status) {
        StatusCommande statusCommande = null;
        if (status != null && !status.isEmpty()) {
            try {
                statusCommande = StatusCommande.valueOf(status); // Convert to enum
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid status value: " + status);
            }
        }
        return commandeRepository.findCommandes(
                clientId != null && !clientId.isEmpty() ? clientId : null,
                variantId != null && !variantId.isEmpty() ? variantId : null,
                commandeId != null && !commandeId.isEmpty() ? commandeId : null,
                price != null && !price.isEmpty() ? price : null,
                statusCommande // Pass the enum directly
        );
    }
}

