package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.Feature;
import com.example.cars_dealership.service.FeatureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @GetMapping
    public String getAllFeatures(Model model) {
        List<Feature> features = featureService.getAllFeatures();
        model.addAttribute("features", features);
        model.addAttribute("feature", new Feature()); // Used for the form
        return "features";
    }

    @PostMapping
    public String saveFeature(@ModelAttribute Feature feature) {
        featureService.saveFeature(feature);
        return "redirect:/features";
    }

    @GetMapping("/{id}")
    public String editFeature(@PathVariable Long id, Model model) {
        Feature feature = featureService.getFeatureById(id);
        List<Feature> features = featureService.getAllFeatures();
        model.addAttribute("feature", feature); // Preload data for the form
        model.addAttribute("features", features);
        return "features";
    }

    @PostMapping("/{id}")
    public String deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return "redirect:/features";
    }
}
