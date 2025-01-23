package com.example.cars_dealership.controller;

import com.example.cars_dealership.enums.StatusReservation;
import com.example.cars_dealership.model.Reservation;
import com.example.cars_dealership.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/reservationes")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public String listReservationes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            Model model) {
        Page<Reservation> reservationesPage = reservationService.getAllReservations(PageRequest.of(page, size));
        model.addAttribute("reservationes", reservationesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", reservationesPage.getTotalPages());
        return "reservationes";
    }


    @PostMapping("/update")
    public String updateReservationStatus(
            @RequestParam Long idReservation,
            @RequestParam StatusReservation statusReservation) {
        reservationService.updateReservationStatus(idReservation, statusReservation);
        return "redirect:/reservationes";
    }

    @GetMapping("/search")
    public String searchReservations(
            @RequestParam(required = false) String clientId,
            @RequestParam(required = false) String variantId,
            @RequestParam(required = false) String reservationId,
            @RequestParam(required = false) String status,
            Model model) {
        List<Reservation> results = reservationService.searchReservations(clientId, variantId, reservationId, status);
        model.addAttribute("reservationes", results);
        model.addAttribute("currentPage", 0);
        model.addAttribute("totalPages", 1);
        return "reservationes";
    }
}

