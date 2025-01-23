package com.example.cars_dealership.controller;

import com.example.cars_dealership.enums.StatusCommande;
import com.example.cars_dealership.model.Commande;
import com.example.cars_dealership.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public String listCommandes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            Model model) {
        Page<Commande> commandesPage = commandeService.getAllCommandes(PageRequest.of(page, size));
        model.addAttribute("commandes", commandesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", commandesPage.getTotalPages());
        return "commandes";
    }

    @PostMapping("/update")
    public String updateCommandeStatus(
            @RequestParam Long idCommande,
            @RequestParam StatusCommande statusCommande) {
        commandeService.updateCommandeStatus(idCommande, statusCommande);
        return "redirect:/commandes";
    }

    @GetMapping("/search")
    public String searchCommandes(
            @RequestParam(required = false) String clientId,
            @RequestParam(required = false) String variantId,
            @RequestParam(required = false) String commandeId,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String status,
            Model model) {
        List<Commande> results = commandeService.searchCommandes(clientId, variantId, commandeId, price, status);
        model.addAttribute("commandes", results);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "commandes";
    }

}




