package com.example.cars_dealership.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/catalog")
    public String Catalog() {
        return "catalog";
    }

    @GetMapping("/stock")
    public String Stock() {
        return "stock";
    }

    @GetMapping("/reservations")
    public String Reservationes() {
        return "redirect:/reservationes?page=0";
    }

    @GetMapping("/commands")
    public String Commandes() {
        return "commandes";
    }
}
