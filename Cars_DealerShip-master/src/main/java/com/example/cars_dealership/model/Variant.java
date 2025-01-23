package com.example.cars_dealership.model;
import com.example.cars_dealership.enums.PowerType;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Variant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVariant;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    @ManyToOne
    private Color color;

    @ManyToOne
    private Moteur moteur;

    @Enumerated(EnumType.STRING)
    private PowerType energie;

    @Column(nullable = false)
    private int stock;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "variant_feature", // Name of the join table
            joinColumns = @JoinColumn(name = "variant_id"), // Foreign key to Variant
            inverseJoinColumns = @JoinColumn(name = "feature_id") // Foreign key to Feature
    )
    private List<Feature> features; // List of features for this variant

    @Column(nullable = false)
    private double basePrice;

    @OneToMany(mappedBy = "variant_images", cascade = CascadeType.ALL)
    private List<Image> variant_images;

    public Variant( Voiture voiture,Color color, Moteur moteur, PowerType energie, int stock, List<Feature> features, double basePrice, List<Image> variant_images) {
        this.voiture = voiture;
        this.color = color;
        this.moteur = moteur;
        this.energie = energie;
        this.stock = stock;
        this.features = features;
        this.basePrice = basePrice;
        this.variant_images = variant_images;
    }
    public Variant() {}


    // Getters & Setters
    public Long getIdVariant() {return idVariant;}

    public void setIdVariant(Long idVariant) {this.idVariant = idVariant;}

    public Color getColor() {return color;}

    public void setColor(Color color) {this.color = color;}

    public Moteur getMoteur() {return moteur;}

    public void setMoteur(Moteur moteur) {this.moteur = moteur;}

    public PowerType getEnergie() {return energie;}

    public void setEnergie(PowerType energie) {this.energie = energie;}

    public int getStock() {return stock;}

    public void setStock(int stock) {this.stock = stock;}

    public Voiture getVoiture() {return voiture;}

    public void setVoiture(Voiture voiture) {this.voiture = voiture;}

    public List<Image> getVariant_images() {return variant_images;}

    public void setVariant_images(List<Image> variant_images) {this.variant_images = variant_images;}

    public List<Feature> getFeatures() {return features;}

    public void setFeatures(List<Feature> features) {this.features = features;}

    public double getBasePrice() {return basePrice;}

    public void setBasePrice(double basePrice) {this.basePrice = basePrice;}


    // methods
    public boolean isAvailable(int stockRequired) {
        return this.stock >= stockRequired;
    }

    public void decrementStock(int quantity) {
        this.stock -= quantity;
    }

    public void updateVariantImage(Image image) {
        this.variant_images.add(image);
    }
}