package com.example.cars_dealership.controller;

import com.example.cars_dealership.model.Color;
import com.example.cars_dealership.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public String getAllColors(Model model) {
        List<Color> colors = colorService.getAllColors();
        model.addAttribute("colors", colors);
        model.addAttribute("color", new Color()); // For the form
        return "colors";
    }

    @PostMapping
    public String saveColor(@ModelAttribute Color color) {
        colorService.saveColor(color);
        return "redirect:/colors";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Color color = colorService.getColorById(id).orElse(null);
        if (color == null) {
            // Redirect to the colors page if the color is not found
            return "redirect:/colors?error=notfound";
        }

        model.addAttribute("color", color);
        model.addAttribute("colors", colorService.getAllColors()); // For the table display
        return "colors";
    }

    @PostMapping("/{id}/edit")
    public String editColor(@PathVariable Long id, @ModelAttribute Color color) {
        Color updatedColor = colorService.editColor(id, color);
        if (updatedColor == null) {
            // Redirect to the colors page if the update fails
            return "redirect:/colors?error=updatefailed";
        }
        return "redirect:/colors";
    }

    @PostMapping("/{id}/delete")
    public String deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return "redirect:/colors";
    }
}


