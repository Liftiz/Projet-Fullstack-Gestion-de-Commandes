// Package dans lequel se trouve la classe
package com.example.demo.model;

// Imports nécessaires
import java.time.LocalDate;            // Pour la date de commande
import java.util.List;                 // Pour la liste de produits

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity // Indique que cette classe est une entité (table dans la base de données)
public class Commande {

    @Id // Identifiant unique de la commande
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation dans la base
    private Long id;

    // Date à laquelle la commande a été passée
    private LocalDate dateCommande;

    // ManyToOne : plusieurs commandes peuvent être passées par un seul client
    @ManyToOne
    @JoinColumn(name = "client_id") // Nom de la colonne dans la base de données (clé étrangère vers Client)
    private Client client;

    // ManyToMany : une commande peut contenir plusieurs produits,
    // et un produit peut être présent dans plusieurs commandes
    @ManyToMany
    @JoinTable(
        name = "commande_produit", // Nom de la table de liaison
        joinColumns = @JoinColumn(name = "commande_id"), // Colonne pour l’ID de commande
        inverseJoinColumns = @JoinColumn(name = "produit_id") // Colonne pour l’ID du produit
    )
    private List<Produit> produits;

    // Constructeur vide requis par JPA
    public Commande() {}

    // Constructeur avec tous les champs utiles
    public Commande(LocalDate dateCommande, Client client, List<Produit> produits) {
        this.dateCommande = dateCommande;
        this.client = client;
        this.produits = produits;
    }

    // Getters & setters

    public Long getId() {
        return id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
