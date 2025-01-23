package com.example.cars_dealership.service;

import com.example.cars_dealership.model.Feature;
import com.example.cars_dealership.repository.FeatureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {
    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id).orElseThrow(() -> new RuntimeException("Feature not found"));
    }

    public void saveFeature(Feature feature) {
        featureRepository.save(feature);
    }

    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
