package com.example.cars_dealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cars_dealership.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
