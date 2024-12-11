package com.example.pal.repository;

import com.example.pal.model.ReservationTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationTestRepository extends JpaRepository<ReservationTest, Long> {
    // Méthodes personnalisées si nécessaire
}
