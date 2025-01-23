package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Color;
import com.example.cars_dealership.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}