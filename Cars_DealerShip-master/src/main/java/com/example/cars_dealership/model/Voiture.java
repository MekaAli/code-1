package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.PowerType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVoiture;

    @Column(nullable = false)
    private String modelName;

    private String description;

    @Column(nullable = false)
    private String marque;

    @OneToMany(mappedBy = "voiture_images", cascade = CascadeType.ALL)
    private List<Image> voiture_images;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL)
    private List<Variant> variants;


    public Voiture(String modelName, String description, String marque, List<Image> voiture_images) {
        this.modelName = modelName;
        this.description = description;
        this.marque = marque;
        this.voiture_images = voiture_images;
    }
    public Voiture() {}


    //Getters & Setters
    public Long getIdVoiture() {return idVoiture;}

    public void setIdVoiture(Long idVoiture) {this.idVoiture = idVoiture;}

    public String getModelName() {return modelName;}

    public void setModelName(String modelName) {this.modelName = modelName;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public String getMarque() {return marque;}

    public void setMarque(String marque) {this.marque = marque;}

    public List<Image> getVoiture_images() {return voiture_images;}

    public void setVoiture_images(List<Image> voiture_images) {this.voiture_images = voiture_images;}

    public List<Variant> getVariants() {return variants;}

    public void setVariants(List<Variant> variants) {this.variants = variants;}
}
