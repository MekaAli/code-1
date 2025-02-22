package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByNomImage(String nomImage);
}

