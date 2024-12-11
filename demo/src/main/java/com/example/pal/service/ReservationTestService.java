package com.example.pal.service;

import com.example.pal.enums.StatusReservationTest;
import com.example.pal.model.ReservationTest;
import com.example.pal.repository.ReservationTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationTestService {

    @Autowired
    private ReservationTestRepository reservationTestRepository;

    // Récupérer toutes les réservations
    public List<ReservationTest> getAllReservations() {
        return reservationTestRepository.findAll();
    }

    // Récupérer une reservation par son ID
    public Optional<ReservationTest> getReservationById(Long id) {
        return reservationTestRepository.findById(id);
    }
    // Ajouter ou mettre à jour une réservation
    public ReservationTest saveOrUpdateReservation(ReservationTest reservation) {
        return reservationTestRepository.save(reservation);
    }

    // Mettre à jour le statut d'une réservation
    public void updateReservationStatus(Long id, String newStatus) {
        // Convert the string status to StatusReservationTest enum
        StatusReservationTest statusReservationTest = StatusReservationTest.valueOf(newStatus.toUpperCase());

        // Find the reservation by id
        ReservationTest reservation = reservationTestRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        // Update the status with the enum value
        reservation.updateStatus(statusReservationTest); // Pass the enum, not the string
        
        // Save the updated reservation
        reservationTestRepository.save(reservation);
    }


    // Mettre à jour le statut d'une réservation
    public void updateReservationStatus(Long id, StatusReservationTest newStatus) {

        // Find the reservation by id
        ReservationTest reservation = reservationTestRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Réservation introuvable"));

        // Update the status with the enum value
        reservation.updateStatus(newStatus); // Pass the enum, not the string
        
        // Save the updated reservation
        reservationTestRepository.save(reservation);
    }

    

    // Supprimer une réservation
    public void deleteReservation(Long id) {
        reservationTestRepository.deleteById(id);
    }
}
