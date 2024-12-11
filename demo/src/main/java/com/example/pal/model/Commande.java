package com.example.pal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

import com.example.pal.enums.StatusCommande;

@Entity
@Table(name = "commandes") // Specifies the database table name
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) // Ensures this relationship is mandatory
    @JoinColumn(name = "client_id", nullable = false) // Foreign key column
    private Client client;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @ManyToOne(optional = false) // Ensures this relationship is mandatory
    @JoinColumn(name = "voiture_id", nullable = false) // Foreign key column
    private Voiture voiture;

    @NotNull
    private double acompte;

    @NotNull
    private double total;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusCommande statusCommande;

    // Default constructor (required by JPA)
    public Commande() {}

    // Parameterized constructor
    public Commande(Client client, Voiture voiture, StatusCommande statusCommande) {
        this.client = client;
        this.voiture = voiture;
        this.statusCommande = statusCommande;
        this.date = new Date(); // Default to current date
        this.acompte = voiture != null ? voiture.calculateTotalPrice() / 10 : 0.0;
        this.total = voiture.calculateTotalPrice();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
        this.acompte = voiture != null ? voiture.calculateTotalPrice() / 10 : 0.0;
    }

    public StatusCommande getStatusCommande() {
        return statusCommande;
    }

    public void setStatusCommande(StatusCommande statusCommande) {
        this.statusCommande = statusCommande;
    }

    public double getAcompte() {
        return acompte;
    }

    public void setAcompte(double acompte) {
        this.acompte = acompte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    // Business Methods
    public void updateStatus(StatusCommande newStatus) {
        this.statusCommande = newStatus;
    }
}

