package com.example.pal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

import com.example.pal.enums.StatusReservationTest;

@Entity
@Table(name = "reservation_test") // Specifies the database table name
public class ReservationTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) // Ensures this relationship is mandatory
    @JoinColumn(name = "client_id", nullable = false) // Foreign key column
    private Client client;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date; // Date of reservation creation

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateTest; // Date of the test

    @ManyToOne(optional = false) // Ensures this relationship is mandatory
    @JoinColumn(name = "voiture_id", nullable = false) // Foreign key column
    private Voiture voiture;

    @Enumerated(EnumType.STRING)
    @NotNull
    private StatusReservationTest statusReservationTest;

    // Default constructor (required by JPA)
    public ReservationTest() {}

    // Parameterized constructor
    public ReservationTest(Client client, Voiture voiture, Date dateTest, StatusReservationTest statusReservationTest) {
        this.client = client;
        this.voiture = voiture;
        this.date = new Date(); // Default to current date
        this.dateTest = dateTest;
        this.statusReservationTest = statusReservationTest;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
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
    }

    public StatusReservationTest getStatusReservationTest() {
        return statusReservationTest;
    }

    public void setStatusReservationTest(StatusReservationTest statusReservationTest) {
        this.statusReservationTest = statusReservationTest;
    }

    // Business method to update status
    public void updateStatus(StatusReservationTest newStatus) {
        this.statusReservationTest = newStatus;
    }
}


