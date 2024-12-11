package com.example.pal.service;

import com.example.pal.model.Option;
import com.example.pal.model.Voiture;
import com.example.pal.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    // Récupérer toutes les voitures
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    // Récupérer une voiture par son id
    
    // public Voiture getVoitureById(Long id) {
    //     return voitureRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande introuvable"));
    // }

    // Récupérer une voiture par son ID
    public Optional<Voiture> getVoitureById(Long id) {
        return voitureRepository.findById(id);
    }

    // Ajouter ou mettre à jour une voiture
    public Voiture saveOrUpdateVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    // Supprimer une voiture
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
    
    // Add an option to a voiture
    public Voiture addOptionToVoiture(Long voitureId, Option option) {
        Voiture voiture = voitureRepository.findById(voitureId)
                .orElseThrow(() -> new RuntimeException("Voiture not found"));

        voiture.getOptions().add(option);
        return voitureRepository.save(voiture);
    }

    // Remove an option from a voiture
    public Voiture removeOptionFromVoiture(Long voitureId, Long optionId) {
        Voiture voiture = voitureRepository.findById(voitureId)
                .orElseThrow(() -> new RuntimeException("Voiture not found"));

        voiture.getOptions().removeIf(option -> option.getId().equals(optionId));
        return voitureRepository.save(voiture);
    }

    // Get all options of a voiture
    public List<Option> getOptionsOfVoiture(Long voitureId) {
        Voiture voiture = voitureRepository.findById(voitureId)
                .orElseThrow(() -> new RuntimeException("Voiture not found"));

        return voiture.getOptions();
    }

}
