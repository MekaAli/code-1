package com.example.pal.controller;

import com.example.pal.model.Option;
import com.example.pal.model.Voiture;
import com.example.pal.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    // Get all voitures
    @GetMapping
    public List<Voiture> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

    // Get voiture by id
    @GetMapping("/{id}")
    public Optional<Voiture> getVoitureById(@PathVariable Long id) {
        return voitureService.getVoitureById(id);
    }

    // Save or update voiture
    @PostMapping
    public Voiture saveOrUpdateVoiture(@RequestBody Voiture voiture) {
        return voitureService.saveOrUpdateVoiture(voiture);
    }

    // Delete voiture by id
    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
    }

    // Add an option to a voiture
    @PostMapping("/{id}/options")
    public Voiture addOptionToVoiture(@PathVariable Long id, @RequestBody Option option) {
        return voitureService.addOptionToVoiture(id, option);
    }

    // Remove an option from a voiture
    @DeleteMapping("/{id}/options/{optionId}")
    public Voiture removeOptionFromVoiture(@PathVariable Long id, @PathVariable Long optionId) {
        return voitureService.removeOptionFromVoiture(id, optionId);
    }

    // Get all options of a voiture
    @GetMapping("/{id}/options")
    public List<Option> getOptionsOfVoiture(@PathVariable Long id) {
        return voitureService.getOptionsOfVoiture(id);
    }
}
