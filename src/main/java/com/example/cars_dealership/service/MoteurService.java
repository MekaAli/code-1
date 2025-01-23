package com.example.cars_dealership.service;

import com.example.cars_dealership.model.Moteur;
import com.example.cars_dealership.repository.MoteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoteurService {
    private final MoteurRepository moteurRepository;

    public MoteurService(MoteurRepository moteurRepository) {
        this.moteurRepository = moteurRepository;
    }

    public List<Moteur> getAllMotors() {
        return moteurRepository.findAll();
    }

    public Optional<Moteur> getMotorById(Long id) {
        return moteurRepository.findById(id);
    }

    public Moteur saveMotor(Moteur moteur) {
        return moteurRepository.save(moteur);
    }

    public Moteur editMotor(Long id, Moteur moteur) {
        if (moteurRepository.existsById(id)) {
            moteur.setId_moteur(id);
            return moteurRepository.save(moteur);
        }
        return null;
    }

    public void deleteMotor(Long id) {
        moteurRepository.deleteById(id);
    }
}
