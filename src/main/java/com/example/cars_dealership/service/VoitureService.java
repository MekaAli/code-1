package com.example.cars_dealership.service;

import com.example.cars_dealership.model.Voiture;
import com.example.cars_dealership.repository.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    public Optional<Voiture> findById(Long id) {
        return voitureRepository.findById(id);
    }

    public Voiture save(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    public void deleteById(Long id) {
        voitureRepository.deleteById(id);
    }
}
