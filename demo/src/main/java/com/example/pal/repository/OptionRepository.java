package com.example.pal.repository;

import com.example.pal.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
    // Méthodes personnalisées si nécessaire
}
