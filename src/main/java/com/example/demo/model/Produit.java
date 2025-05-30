// Déclare que la classe fait partie du package model
package com.example.demo.model;

// Import des annotations nécessaires à la gestion JPA
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

// Indique que cette classe est une entité JPA (correspond à une table dans la base)
@Entity
public class Produit {

    // Clé primaire de la table Produit
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentée par la base
    private Long id;

    // Nom du produit (colonne simple)
    private String nom;

    // Prix du produit
    private double prix;

    // Relation MANY-TO-MANY inverse avec la table Commande
    // Un produit peut appartenir à plusieurs commandes
    @ManyToMany(mappedBy = "produits") // "produits" est le nom du champ côté Commande
    private List<Commande> commandes;

    // Constructeur vide requis par JPA
    public Produit() {}

    // Constructeur avec les champs utiles à la création
    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getter de l'identifiant
    public Long getId() {
        return id;
    }

    // Getter et setter du nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et setter du prix
    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Getter et setter de la liste des commandes associées
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
