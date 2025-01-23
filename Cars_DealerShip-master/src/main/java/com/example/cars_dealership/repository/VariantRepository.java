package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, Long> {
}
