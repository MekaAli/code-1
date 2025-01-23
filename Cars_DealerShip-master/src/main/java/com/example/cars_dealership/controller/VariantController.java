package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.Variant;
import com.example.cars_dealership.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variant")
public class VariantController {

    @Autowired
    private VariantRepository variantRepository;

    @GetMapping("/{id}")
    public String getVariantDetails(@PathVariable Long id, Model model) {
        Variant variant = variantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Variant not found"));
        model.addAttribute("variant", variant);
        return "variant";
    }
}

