// Le package dans lequel se trouve cette classe
package com.example.demo.model;

// Importation des bibliothèques nécessaires
import java.util.List; // Pour gérer une liste de commandes

import com.fasterxml.jackson.annotation.JsonIgnore; // Pour éviter les boucles infinies dans la réponse JSON

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// Indique que cette classe représente une table dans la base de données
@Entity
public class Client {

    // Identifiant unique (clé primaire) auto-généré
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Attributs simples (colonnes de la table)
    private String nom;
    private String email;

    // Relation OneToMany : un client peut avoir plusieurs commandes
    @OneToMany(mappedBy = "client") // "client" est le nom du champ dans l’entité Commande
    @JsonIgnore // Empêche la sérialisation infinie dans le JSON (évite les boucles dans les réponses REST)
    private List<Commande> commandes;

    // Constructeur vide obligatoire pour JPA
    public Client() {}

    // Constructeur pratique pour créer un client rapidement
    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Getters & setters pour accéder aux données et permettre la modification

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
