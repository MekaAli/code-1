package com.example.pal.model;

import java.util.ArrayList;
import java.util.List;

import com.example.pal.enums.Disponibilite;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "voitures")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String model;

    @NotNull
    private int puissance;

    @NotNull
    private double prix; // Base price of the car

    @NotNull
    private String type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();

    // Default constructor (required by JPA)
    public Voiture() {}

    // Parameterized constructor
    public Voiture(String model,String type, int puissance, double prix, Disponibilite disponibilite, List<Option> options) {
        this.model = model;
        this.type = type;
        this.puissance = puissance;
        this.prix = prix;
        this.disponibilite = disponibilite;
        this.options = options;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Disponibilite getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Disponibilite disponibilite) {
        this.disponibilite = disponibilite;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    // Method to calculate the total price
    public double calculateTotalPrice() {
        double totalPrice = prix; // Start with base price
        for (Option option : options) {
            totalPrice += option.getPrix();
        }
        return totalPrice;
    }

}
