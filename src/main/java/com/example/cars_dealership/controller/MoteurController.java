package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.Moteur;
import com.example.cars_dealership.service.MoteurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/motors")
public class MoteurController {
    private final MoteurService moteurService;

    public MoteurController(MoteurService moteurService) {
        this.moteurService = moteurService;
    }

    @GetMapping
    public String getAllMotors(Model model) {
        List<Moteur> motors = moteurService.getAllMotors();
        model.addAttribute("motors", motors);
        model.addAttribute("moteur", new Moteur()); // For the form
        return "motors";
    }

    @PostMapping
    public String saveMotor(@ModelAttribute Moteur moteur) {
        moteurService.saveMotor(moteur);
        return "redirect:/motors";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Moteur moteur = moteurService.getMotorById(id).orElse(null);
        if (moteur == null) {
            return "redirect:/motors?error=notfound";
        }
        model.addAttribute("moteur", moteur);
        model.addAttribute("motors", moteurService.getAllMotors()); // For the table display
        return "motors";
    }

    @PostMapping("/{id}/edit")
    public String editMotor(@PathVariable Long id, @ModelAttribute Moteur moteur) {
        Moteur updatedMoteur = moteurService.editMotor(id, moteur);
        if (updatedMoteur == null) {
            return "redirect:/motors?error=updatefailed";
        }
        return "redirect:/motors";
    }

    @PostMapping("/{id}/delete")
    public String deleteMotor(@PathVariable Long id) {
        moteurService.deleteMotor(id);
        return "redirect:/motors";
    }
}
