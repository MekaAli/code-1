package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Moteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoteurRepository extends JpaRepository<Moteur, Long> {
}
