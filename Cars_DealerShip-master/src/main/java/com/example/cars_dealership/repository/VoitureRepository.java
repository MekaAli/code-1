package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
}
