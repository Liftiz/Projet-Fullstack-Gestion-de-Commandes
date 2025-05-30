// Ce fichier fait partie du package "service" : il contient la logique métier liée à l'entité Produit
package com.example.demo.service;

// Importation des classes nécessaires
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Produit;
import com.example.demo.repository.ProduitRepository;

// Annotation qui indique que cette classe est un "service" Spring
// Elle sera automatiquement détectée et instanciée (comme un composant métier)
@Service
public class ProduitService {

    // Injection automatique du repository par Spring
    @Autowired
    private ProduitRepository produitRepository;

    // Méthode pour récupérer tous les produits (GET)
    public List<Produit> getAll() {
        // On appelle la méthode "findAll" fournie automatiquement par JpaRepository
        return produitRepository.findAll();
    }

    // Méthode pour enregistrer un nouveau produit (POST)
    public Produit create(Produit produit) {
        // "save" permet d'enregistrer un produit dans la base
        // S’il a déjà un id → il est mis à jour, sinon il est créé
        return produitRepository.save(produit);
    }
}
