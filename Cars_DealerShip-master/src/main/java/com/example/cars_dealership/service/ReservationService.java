package com.example.cars_dealership.service;

import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.Reservation;
import com.example.cars_dealership.model.User;
import com.example.cars_dealership.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Get all reservations with pagination
    public Page<Reservation> getAllReservations(Pageable pageable) {
        return reservationRepository.findAllByOrderByDateDesc(pageable);
    }

    //Get all Reservations for a Client
    public List<Reservation> getReservationsByClient(User client) {
        return reservationRepository.findAllByClient(client);
    }

    // Get reservations by status
    public List<Reservation> getReservationsByStatus(StatusReservation status) {
        return reservationRepository.findByStatusReservation(status);
    }

    //Confirme Reservation
    public void confirmationReservation(Reservation reservation) {
        reservation.confirm();
        reservationRepository.save(reservation);
    }

    //Annulee Commande
    public void cancelCommande(Reservation reservation) {
        reservation.cancel(); // Call the entity method
        reservationRepository.save(reservation); // Persist the change using the instance
    }

    //Reservation Effectuee
    public void completeCommande(Reservation reservation) {
        reservation.complete();
        reservationRepository.save(reservation);
    }

    // Update reservation status
    public void updateReservationStatus(Long idReservation, StatusReservation statusReservation) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found."));
        reservation.setStatusReservation(statusReservation);
        reservationRepository.save(reservation);
    }

    // Search reservations
    public List<Reservation> searchReservations(String clientId, String variantId, String reservationId, String status) {
        StatusReservation statusEnum = null;
        if (status != null && !status.isEmpty()) {
            try {
                statusEnum = StatusReservation.valueOf(status);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid status value: " + status);
            }
        }
        return reservationRepository.findReservations(
                clientId != null && !clientId.isEmpty() ? clientId : null,
                variantId != null && !variantId.isEmpty() ? variantId : null,
                reservationId != null && !reservationId.isEmpty() ? reservationId : null,
                statusEnum
        );
    }
}