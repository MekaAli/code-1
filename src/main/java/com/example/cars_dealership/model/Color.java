package com.example.cars_dealership.model;
import jakarta.persistence.*;

@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_color;

    @Column(nullable = false)
    private String nom_color;

    @Column(nullable = false)
    private String xcode;

    public Color(String nom_color, String xcode) {
        this.nom_color = nom_color;
        this.xcode = xcode;
    }
    public Color() {}


    // Getters & Setters

    public Long getId_color() {
        return id_color;
    }

    public void setId_color(Long id_color) {
        this.id_color = id_color;
    }

    public String getNom_color() {
        return nom_color;
    }

    public void setNom_color(String nom_color) {
        this.nom_color = nom_color;
    }

    public String getXcode() {
        return xcode;
    }

    public void setXcode(String xcode) {
        this.xcode = xcode;
    }

}


