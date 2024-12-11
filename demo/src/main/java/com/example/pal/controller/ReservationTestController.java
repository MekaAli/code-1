package com.example.pal.controller;

import com.example.pal.model.ReservationTest;
import com.example.pal.enums.StatusReservationTest;
import com.example.pal.service.ReservationTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationTestController {

    @Autowired
    private ReservationTestService reservationTestService;

    // Get all reservations
    @GetMapping
    public List<ReservationTest> getAllReservations() {
        return reservationTestService.getAllReservations();
    }

    // Get reservation by id
    @GetMapping("/{id}")
    public Optional<ReservationTest> getReservationById(@PathVariable Long id) {
        return reservationTestService.getReservationById(id);
    }

    // Save or update reservation
    @PostMapping
    public ReservationTest saveOrUpdateReservation(@RequestBody ReservationTest reservationTest) {
        return reservationTestService.saveOrUpdateReservation(reservationTest);
    }

    // Update the status of a reservation
    @PutMapping("/{id}/status")
    public void updateReservationStatus(@PathVariable Long id, @RequestParam StatusReservationTest newStatus) {
        reservationTestService.updateReservationStatus(id, newStatus);
    }

    // Delete reservation by id
    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationTestService.deleteReservation(id);
    }
}
