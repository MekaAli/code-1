package com.example.cars_dealership.repository;

import com.example.cars_dealership.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
