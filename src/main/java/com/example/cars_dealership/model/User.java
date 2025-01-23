package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.Role;
import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String nom;
    private String prenom;
    private String numeroTel;
    private String adresseEmail;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;

    // Constructor
    public User(String nom, String prenom, String numeroTel, String adresseEmail, Role role, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroTel = numeroTel;
        this.adresseEmail = adresseEmail;
        this.role = role;
        this.password = password;
    }

    public User() {
    }


    //Setters & Getters
    public Long getId_user() {return id_user;}
    public void setId_user(Long id_user) {this.id_user = id_user;}
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNumeroTel() {
        return numeroTel;
    }
    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
    public String getAdresseEmail() {
        return adresseEmail;
    }
    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}