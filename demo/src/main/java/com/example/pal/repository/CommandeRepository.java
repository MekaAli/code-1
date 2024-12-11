package com.example.pal.repository;

import com.example.pal.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Exemples de requêtes personnalisées :
    // List<Commande> findByClient_Id(Long clientId);
    // List<Commande> findByStatusCommande(StatusCommande status);
}
