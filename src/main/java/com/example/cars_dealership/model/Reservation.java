package com.example.cars_dealership.model;

import com.example.cars_dealership.enums.StatusReservation;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne
    @JoinColumn(name = "client_id") // Foreign key to User
    private User client;

    @ManyToOne
    @JoinColumn(name = "variant_id") // Foreign key to Variant
    private Variant variant;

    @Enumerated(EnumType.STRING)
    private StatusReservation statusReservation;
    private Date date;

    public Reservation(User client, Variant variant, StatusReservation statusReservation, Date date) {
        this.client = client;
        this.variant = variant;
        this.statusReservation = StatusReservation.EN_ATTENTE;
        this.date = date;
    }
    public Reservation() {}


    //Getters & Setters
    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public StatusReservation getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(StatusReservation statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    //methods
    public void confirm() {
        this.statusReservation = StatusReservation.CONFIRMEE;
    }

    public void complete() {
        this.statusReservation = StatusReservation.EFFECTUEE;
    }

    public void cancel() {this.statusReservation = StatusReservation.ANNULEE;}
}