package com.example.cars_dealership.service;

import com.example.cars_dealership.model.Color;
import com.example.cars_dealership.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Optional<Color> getColorById(Long id) {
        return colorRepository.findById(id);
    }

    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }

    // Add a method to edit a color
    public Color editColor(Long id, Color color) {
        Color colorToEdit = colorRepository.findById(id).orElse(null);
        if (colorToEdit != null) {
            colorToEdit.setXcode(color.getXcode());
            colorToEdit.setNom_color(color.getNom_color());
            return colorRepository.save(colorToEdit);
        }
        return null;
    }
}
