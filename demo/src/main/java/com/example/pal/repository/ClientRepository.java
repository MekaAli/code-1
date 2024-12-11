package com.example.pal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pal.model.*;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // No need to add any code here, JpaRepository provides standard CRUD operations
}
