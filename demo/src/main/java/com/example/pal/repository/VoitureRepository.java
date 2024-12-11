package com.example.pal.repository;

import com.example.pal.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    // Ajoutez des méthodes personnalisées si nécessaire, ex. :
    // List<Voiture> findByDisponibilite(Disponibilite disponibilite);
}
