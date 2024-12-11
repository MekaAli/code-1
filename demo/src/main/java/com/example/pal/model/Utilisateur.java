package com.example.pal.model;

import java.util.Date;

import com.example.pal.enums.Role;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role = Role.CLIENT;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    // Default constructor (required by JPA)
    public Utilisateur() {
        this.date = new Date(); // Default to the current date
    }

    // Parameterized constructor
    public Utilisateur(Role role, String motDePasse, String email) {
        this.role = role != null ?role : Role.CLIENT;
        this.email = email;
        this.motDePasse = motDePasse;
        this.date = new Date(); // Default to the current date
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


