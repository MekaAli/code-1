package com.example.cars_dealership.model;
import jakarta.persistence.*;

@Entity
public class Moteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_moteur;

    @Column(nullable = false)
    private String nom_moteur;

    @Column(nullable = false)
    private String puissance;

    @Column(nullable = false)
    private String description;

    public Moteur(String nom_moteur, String puissance, String description) {
        this.nom_moteur = nom_moteur;
        this.puissance = puissance;
        this.description = description;
    }
    public Moteur() {}


    // Getters & Setters
    public Long getId_moteur() {
        return id_moteur;
    }

    public void setId_moteur(Long id_moteur) {
        this.id_moteur = id_moteur;
    }

    public String getNom_moteur() {
        return nom_moteur;
    }

    public void setNom_moteur(String nom_moteur) {
        this.nom_moteur = nom_moteur;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


