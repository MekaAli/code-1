package com.example.pal.controller;

import com.example.pal.model.Commande;
import com.example.pal.enums.StatusCommande;
import com.example.pal.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    // Get all commandes
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    // Get commande by id
    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    // Save or update commande
    @PostMapping
    public Commande saveOrUpdateCommande(@RequestBody Commande commande) {
        return commandeService.saveOrUpdateCommande(commande);
    }

    // Update the status of a commande
    @PutMapping("/{id}/status")
    public void updateCommandeStatus(@PathVariable Long id, @RequestParam StatusCommande newStatus) {
        commandeService.updateCommandeStatus(id, newStatus);
    }

    // Delete commande by id
    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}
