package com.example.pal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pal.model.Option;
import com.example.pal.repository.OptionRepository;

@Service
public class OptionService {
    @Autowired
    private OptionRepository optionRepository;

    // Récupérer toutes les options
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }
    
    // Ajouter ou mettre à jour une option
    public Option saveOrUpdateOption(Option option) {
        return optionRepository.save(option);
    }


    // Supprimer une option
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }
}
