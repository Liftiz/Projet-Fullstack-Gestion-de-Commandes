// Ce fichier fait partie du package "controller" : il contient les classes qui gèrent les requêtes HTTP
package com.example.demo.controller;

// Imports nécessaires pour manipuler des listes et des annotations REST
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produit;
import com.example.demo.service.ProduitService;

@CrossOrigin(origins = "http://localhost:3000")

// Cette annotation transforme la classe en contrôleur REST : elle peut recevoir des requêtes HTTP
@RestController

// Toutes les routes de cette classe commenceront par /produits
@RequestMapping("/produits")
public class ProduitController {

    // Injection automatique du service ProduitService par Spring
    @Autowired
    private ProduitService produitService;

    // Route GET /produits → permet de récupérer la liste de tous les produits
    @GetMapping
    public List<Produit> getAllProduits() {
        // Appelle la méthode getAll() du service pour retourner les produits
        return produitService.getAll();
    }

    // Route POST /produits → permet d’ajouter un nouveau produit à la base
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        // @RequestBody indique que le JSON reçu dans le corps de la requête sera converti en objet Produit
        return produitService.create(produit);
    }
}